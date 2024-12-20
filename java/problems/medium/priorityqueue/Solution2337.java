package problems.medium.priorityqueue;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/move-pieces-to-obtain-a-string">
 * move-pieces-to-obtain-a-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2337 {
    public boolean canChange(String start, String target) {
        char[] charsStart = start.toCharArray();
        char[] charsTarget = target.toCharArray();
        Queue<Integer> posL = new PriorityQueue<>();
        Queue<Integer> posR = new PriorityQueue<>();
        for (int i = 0; i < charsStart.length; i++) {
            if (charsStart[i] == 'L') {
                posL.add(i);
            }
            if (charsStart[i] == 'R') {
                posR.add(i);
            }
        }

        for (int i = 0; i < charsTarget.length; i++) {
            if (charsTarget[i] == 'L') {
                if (posL.isEmpty() || posL.peek() < i || (!posR.isEmpty() && posL.peek() > posR.peek())) {
                    return false;
                }
                posL.poll();
            } else if (charsTarget[i] == 'R') {
                if (posR.isEmpty() || posR.peek() > i || (!posL.isEmpty() && posL.peek() < posR.peek())) {
                    return false;
                }
                posR.poll();
            }
        }
        return posL.isEmpty() && posR.isEmpty();
    }
}
