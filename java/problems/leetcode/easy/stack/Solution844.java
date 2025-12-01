package problems.leetcode.easy.stack;


import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/backspace-string-compare">
 * backspace-string-compare</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        int index1 = s.length() - 1;
        int index2 = t.length() - 1;
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int toDelete1 = 0;
        int toDelete2 = 0;
        while (index1 >= 0 || index2 >= 0) {
            if ((index1 >= 0 && charS[index1] == '#') || (index2 >= 0 && charT[index2] == '#')) {
                if (index1 >= 0 && charS[index1] == '#') {
                    index1--;
                    toDelete1++;
                }
                if (index2 >= 0 && charT[index2] == '#') {
                    index2--;
                    toDelete2++;
                }
            } else if (toDelete1 > 0 || toDelete2 > 0) {
                if (toDelete1 > 0) {
                    toDelete1--;
                    index1--;
                }
                if (toDelete2 > 0) {
                    toDelete2--;
                    index2--;
                }
            } else if (index1 >= 0 && index2 >= 0 && charS[index1] != '#' && charT[index2] != '#') {
                if (charS[index1] != charT[index2]) {
                    return false;
                } else {
                    index1--;
                    index2--;
                }
            } else {
                return false;
            }
        }

        return index1 < 0 && index2 < 0;
    }

    public boolean backspaceCompare2(String s, String t) {
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
