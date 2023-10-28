package problems.medium.stack;


import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/backspace-string-compare">
 * backspace-string-compare</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sQueue = new Stack<>();
        Stack<Character> tQueue = new Stack<>();
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (charS[i] != '#') {
                sQueue.add(charS[i]);
            } else if (!sQueue.isEmpty()) {
                sQueue.pop();
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (charT[i] != '#') {
                tQueue.add(charT[i]);
            } else if (!tQueue.isEmpty()) {
                tQueue.pop();
            }
        }

        while (!sQueue.isEmpty() && !tQueue.isEmpty()) {
            Character sChar = sQueue.pop();
            Character tChar = tQueue.pop();
            if (sChar != tChar) {
                return false;
            }
        }

        return sQueue.isEmpty() && tQueue.isEmpty();
    }
}
