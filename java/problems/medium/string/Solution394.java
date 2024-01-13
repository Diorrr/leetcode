package problems.medium.string;


import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/decode-string">
 * decode-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution394 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                int left = i;
                while (Character.isDigit(s.charAt(left))) {
                    left++;
                }
                int repeat = Integer.parseInt(s.substring(i, left));
                int count = 1;
                int right = left + 1;
                while (count != 0 && right < s.length()) {
                    if (s.charAt(right) == ']') {
                        count--;
                    } else if (s.charAt(right) == '[') {
                        count++;
                    }
                    right++;
                }
                sb.append(decodeString(s.substring(left + 1, right - 1)).repeat(repeat));
                i = right - 1;
            }
        }

        return sb.toString();
    }

    public String decodeString2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop();
                String sub = sb.reverse().toString();

                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.append(stack.pop());
                }
                int repeat = Integer.parseInt(sb.reverse().toString());

                while (repeat > 0) {
                    for (char ch : sub.toCharArray()) {
                        stack.push(ch);
                    }
                    repeat--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}
