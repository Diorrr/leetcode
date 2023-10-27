package problems.medium.stack;


import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation">
 * evaluate-reverse-polish-notation</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (String token : tokens) {
            try {
                Integer number = Integer.parseInt(token);
                numbers.push(number);
            } catch (Exception e) {
                Integer second = numbers.pop();
                Integer first = numbers.pop();
                Integer res = calculate(first, second, token);
                numbers.push(res);
            }
        }
        return numbers.pop();
    }

    private Integer calculate(Integer first, Integer second, String operator) {
        return switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "/" -> first / second;
            default -> first * second;
        };
    }

    boolean isNumeric(String operand) {
        try {
            Integer.parseInt(operand);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
