package problems.leetcode.easy.sorting;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone">
 * minimum-number-of-moves-to-seat-everyone</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        int res = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(students[i] - seats[i]);
        }
        return res;
    }

    public int minMovesToSeat1(int[] seats, int[] students) {
        int res = 0;
        PriorityQueue<Integer> seatsQueue = new PriorityQueue<>();
        PriorityQueue<Integer> studentsQueue = new PriorityQueue<>();

        seatsQueue.addAll(Arrays.stream(seats).boxed().toList());
        studentsQueue.addAll(Arrays.stream(students).boxed().toList());

        while (!seatsQueue.isEmpty()) {
            res += Math.abs(seatsQueue.poll() - studentsQueue.poll());

        }
        return res;
    }

    public static void main(String[] args) {

    }
}
