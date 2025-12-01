package problems.leetcode.hard.stack;


import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/largest-rectangle-in-histogram">
 * largest-rectangle-in-histogram</a>
 * ref : https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-using-stack/
 * Time Complexity:
 * Space Complexity：
 */
class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int idx = 0;

        while (idx < heights.length) {
            if (stack.isEmpty() || heights[idx] >= heights[stack.peek()]) {
                stack.add(idx++);
            } else {
                int top = stack.pop();
                res = Math.max(res, heights[top] * (stack.isEmpty() ? idx : idx - stack.peek() - 1));
            }
        }

        while (!stack.isEmpty()){
            int top = stack.pop();
            res = Math.max(res, heights[top] * (stack.isEmpty() ? idx : idx - stack.peek() - 1));
        }

        return res;
    }
}
