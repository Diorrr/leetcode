package problems.leetcode.medium.sim;


import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements">
 * find-score-of-an-array-after-marking-all-elements</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2593 {
    public long findScore(int[] nums) {
        long res = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (nums[curr[1]] == curr[0]) {
                res += curr[0];
                nums[curr[1]] = -1;
                if (curr[1] > 0) {
                    nums[curr[1] - 1] = -1;
                }
                if (curr[1] + 1 < nums.length) {
                    nums[curr[1] + 1] = -1;
                }
            }
        }

        return res;
    }
}
