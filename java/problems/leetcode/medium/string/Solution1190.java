package problems.leetcode.medium.string;


import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses">
 * reverse-substrings-between-each-pair-of-parentheses</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1190 {
    public String reverseParentheses(String s) {
        StringBuilder res = new StringBuilder();
        char[] word = s.toCharArray();
        Stack<Integer> open = new Stack<>();
        for (int i = 0; i < word.length; i++) {
            if (word[i] == '(') {
                open.add(i);
            } else if (word[i] == ')') {
                int l = open.pop();
                int r = i;
                while (l < r) {
                    char temp = word[l];
                    word[l] = word[r];
                    word[r] = temp;
                    l++;
                    r--;
                }
            }
        }
        for (char c : word) {
            if (c != '(' && c != ')') {
                res.append(c);
            }
        }
        return res.toString();
    }
}
