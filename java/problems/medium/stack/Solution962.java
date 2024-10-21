package problems.medium.stack;


import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-width-ramp">
 * maximum-width-ramp</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution962 {
    public int maxWidthRamp(int[] nums) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.add(i);
            }
        }
        for (int i = nums.length - 1; i > res; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }
}
