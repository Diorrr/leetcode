package problems.easy.priorityqueue;


import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i">
 * final-array-state-after-k-multiplication-operations-i</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0]
                ? Integer.compare(a[0], b[0])
                : Integer.compare(a[1], b[1]));
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
        }

        while (k > 0) {
            k--;
            int[] curr = queue.poll();
            nums[curr[1]] *= multiplier;
            curr[0] *= multiplier;
            queue.add(curr);
        }
        return nums;
    }
}
