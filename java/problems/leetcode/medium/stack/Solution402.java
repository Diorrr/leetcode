package problems.leetcode.medium.stack;


import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-k-digits">
 * remove-k-digits</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution402 {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.add(digit);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        res = res.reverse();
        while (!res.isEmpty() && res.charAt(0)=='0'){
            res.deleteCharAt(0);
        }

        return res.isEmpty() ? "0" : res.toString();
    }
}
