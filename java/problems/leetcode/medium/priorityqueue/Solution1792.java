package problems.leetcode.medium.priorityqueue;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-average-pass-ratio">
 * maximum-average-pass-ratio</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double res = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingDouble(a -> -(a[0] + 1.0) / (a[1] + 1) + ((double) a[0] / a[1])));
        queue.addAll(Arrays.asList(classes));
        while (extraStudents > 0) {
            int[] curr = queue.poll();
            curr[0]++;
            curr[1]++;
            queue.add(curr);
            extraStudents--;
        }
        for (int[] ints : queue) {
            res += (double) ints[0] / ints[1];
        }

        return res / classes.length;
    }
}
