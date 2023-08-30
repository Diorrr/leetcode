package problems.easy.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/valid-parentheses">
 * valid-parentheses</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution20 {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        if (chars[0] == ')' || chars[0] == '}' || chars[0] == ']') {
            return false;
        }
        deque.add(chars[0]);
        for (int i = 1; i < s.length(); i++) {
            char curr = chars[i];
            if (curr == '(' || curr == '{' || curr == '[') {
                deque.add(curr);
            } else if (!deque.isEmpty()) {
                char prev = deque.removeLast();
                if ((prev == '(' && curr != ')')
                        || (prev == '{' && curr != '}')
                        || (prev == '[' && curr != ']')) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return deque.isEmpty();
    }

    public boolean isValid2(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        Set<Character> openingSet = Set.of('(', '{', '[');
        Set<Character> closingSet = Set.of(')', '}', ']');

        if (closingSet.contains(chars[0])) {
            return false;
        }
        deque.add(chars[0]);
        for (int i = 1; i < s.length(); i++) {
            char curr = chars[i];
            if (openingSet.contains(curr)) {
                deque.add(curr);
            } else if (!deque.isEmpty()) {
                char prev = deque.removeLast();
                if ((prev == '(' && curr != ')')
                        || (prev == '{' && curr != '}')
                        || (prev == '[' && curr != ']')) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return deque.isEmpty();
    }
}
