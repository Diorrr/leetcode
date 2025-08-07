package problems.medium.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < nums2.length; i++) {
            queue.add(new int[]{0, i, nums1[0] + nums2[i]});
        }

        while (res.size() < k && !queue.isEmpty()) {
            int[] curr = queue.poll();
            res.add(List.of(nums1[curr[0]], nums2[curr[1]]));
            if (curr[0] + 1 < nums1.length) {
                queue.offer(new int[]{curr[0] + 1, curr[1], nums1[curr[0] + 1] + nums2[curr[1]]});
            }
        }

        return res;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[0] + b[1], a[0] + a[1]));
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (queue.size() < k) {
                    queue.offer(new int[]{num1, num2});
                } else if (num1 + num2 < queue.peek()[0] + queue.peek()[1]) {
                    queue.poll();
                    queue.offer(new int[]{num1, num2});
                }
            }
        }
        queue.forEach(queueItem -> res.add(List.of(queueItem[0], queueItem[1])));

        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution373().kSmallestPairs2(new int[]{1, 1, 2}, new int[]{1,2, 3}, 2)
        );
    }
}
