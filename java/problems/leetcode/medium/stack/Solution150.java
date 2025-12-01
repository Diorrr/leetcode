package problems.leetcode.medium.stack;


import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation">
 * evaluate-reverse-polish-notation</a>
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> numbers.push(numbers.pop() + numbers.pop());
                case "-" -> numbers.push(-numbers.pop() + numbers.pop());
                case "*" -> numbers.push(numbers.pop() * numbers.pop());
                case "/" -> {
                    Integer second = numbers.pop();
                    numbers.push(numbers.pop() / second);
                }
                default -> numbers.push(Integer.valueOf(token));
            }
        }

        return numbers.pop();
    }
}
