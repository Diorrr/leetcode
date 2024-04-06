package problems.easy.stack;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/make-the-string-great">
 * make-the-string-great</a>
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution1544 {
    public String makeGood(String s) {
        int diff = 'a' - 'A';
        StringBuilder res = new StringBuilder();
        Deque<Character> dequeue = new LinkedList<>();
        char[] sChars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (!dequeue.isEmpty() && Math.abs(dequeue.peek() - sChars[i]) == diff) {
                dequeue.removeFirst();
            } else {
                dequeue.addFirst(sChars[i]);
            }
        }
        while (!dequeue.isEmpty()) {
            res.append(dequeue.pollLast());
        }
        return res.toString();
    }

    public String makeGood2(String s) {
        int diff = 'a' - 'A';
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            var curr = s.charAt(i);
            if (!stack.isEmpty() && Math.abs(stack.peek() - curr) == diff) {
                stack.pop();
            } else {
                stack.add(curr);
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
