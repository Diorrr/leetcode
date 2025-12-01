package problems.leetcode.medium.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: https://leetcode.com/problems/k-closest-points-to-origin/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution973 {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
        return Arrays.copyOfRange(points, 0, k);
    }

    public int[][] kClosest2(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
        queue.addAll(Arrays.asList(points));
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }

        return res;
    }
}
