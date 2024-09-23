package problems.medium.recursion;


import java.util.LinkedList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/different-ways-to-add-parentheses">
 * different-ways-to-add-parentheses</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char sign = expression.charAt(i);
            if (sign == '-' || sign == '+' || sign == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (Integer leftValue : left) {
                    for (Integer rightValue : right) {
                        if (sign == '-') {
                            res.add(leftValue - rightValue);
                        } else if (sign == '+') {
                            res.add(leftValue + rightValue);
                        } else {
                            res.add(leftValue * rightValue);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
}
