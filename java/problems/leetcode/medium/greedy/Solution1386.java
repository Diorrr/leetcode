package problems.leetcode.medium.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/cinema-seat-allocation">
 * cinema-seat-allocation</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, boolean[]> seatsTaken = new HashMap<>();
        int countEmptyRows = n;
        for (int[] reservedSeat : reservedSeats) {
            countEmptyRows -= seatsTaken.containsKey(reservedSeat[0]) ? 0 : 1;
            boolean[] seats = seatsTaken.getOrDefault(reservedSeat[0], new boolean[11]);
            seats[reservedSeat[1]] = true;
            seatsTaken.put(reservedSeat[0], seats);
        }
        int res = 2 * countEmptyRows;
        for (boolean[] seats : seatsTaken.values()) {
            res += countGroupsAssigned(seats);
        }
        return res;
    }

    private int countGroupsAssigned(boolean[] seat) {
        int freeGroup1AndGroup3 = getCountOfAssignedGroups(seat, 2, 5);
        freeGroup1AndGroup3 += getCountOfAssignedGroups(seat, 6, 9);
        int freeGroup2 = getCountOfAssignedGroups(seat, 4, 7);
        return Math.max(freeGroup1AndGroup3, freeGroup2);
    }

    private int getCountOfAssignedGroups(boolean[] seat, int start, int end){
        for (int i = start; i <= end; i++) {
            if (seat[i]) {
                return 0;
            }
        }
        return 1;
    }
}
