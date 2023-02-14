package problems.medium.arrays;

import java.util.ArrayList;
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
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < nums2.length; i++) {
            queue.add(new int[]{0, i, nums1[0] + nums2[i]});
        }

        while (res.size() < k && !queue.isEmpty()){
            int[] curr = queue.poll();
            res.add(List.of(nums1[curr[0]], nums2[curr[1]]));
            if (curr[0] + 1 < nums1.length) {
                queue.offer(new int[]{curr[0] + 1, curr[1], nums1[curr[0] + 1] + nums2[curr[1]]});
            }
        }

        return res;
    }
}
