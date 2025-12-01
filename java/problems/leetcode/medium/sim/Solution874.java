package problems.leetcode.medium.sim;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/walking-robot-simulation">
 * walking-robot-simulation</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int res = 0;
        int currX = 0;
        int currY = 0;
        int dirInd = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        HashMap<Integer, Set<Integer>> rows = new HashMap<>();
        HashMap<Integer, Set<Integer>> cols = new HashMap<>();
        for (int[] obstacle : obstacles) {
            rows.putIfAbsent(obstacle[1], new HashSet<>());
            rows.get(obstacle[1]).add(obstacle[0]);
            cols.putIfAbsent(obstacle[0], new HashSet<>());
            cols.get(obstacle[0]).add(obstacle[1]);
        }
        for (int command : commands) {
            if (command == -1) {
                dirInd = (dirInd + 1) % 4;
            } else if (command == -2) {
                dirInd = (dirInd + 3) % 4;
            } else {
                while (command > 0) {
                    int newX = currX + dir[dirInd][0];
                    int newY = currY + dir[dirInd][1];
                    if ((rows.containsKey(newY) && rows.get(newY).contains(newX))
                            || (cols.containsKey(newX) && cols.get(newX).contains(newY))) {
                        break;
                    }
                    currX = newX;
                    currY = newY;
                    command--;
                }
            }
            res = Math.max(currX * currX + currY * currY, res);
        }

        return res;
    }
}
