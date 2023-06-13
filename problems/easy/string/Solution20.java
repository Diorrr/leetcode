package problems.easy.string;

import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/valid-parentheses">
 * valid-parentheses</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                stack.add(curr);
            } else if (!stack.isEmpty()) {
                char prev = stack.pop();
                if ((prev == '(' && curr != ')')
                        || (prev == '{' && curr != '}')
                        || (prev == '[' && curr != ']')) {
                    return false;
                } else if (prev == ')' || prev == '}' || prev == ']') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
