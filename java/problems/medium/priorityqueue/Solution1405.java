package problems.medium.priorityqueue;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/longest-happy-string">
 * longest-happy-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1405 {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(t -> (-t[0])));
        insertToQueue(pq, a + 1, 0);
        insertToQueue(pq, b + 1, 1);
        insertToQueue(pq, c + 1, 2);
        int prevType = -1;
        int occurance = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int type = curr[1];
            char toAdd = (char) ('a' + type);
            int rem = curr[0];
            if (type != prevType || occurance == 1) {
                if (insertToQueue(pq, rem, type)) {
                    sb.append(toAdd);
                    occurance = prevType != type ? 1 : 2;
                    prevType = type;
                }
            } else if (!pq.isEmpty()) {
                int[] newCurr = pq.poll();
                int newType = newCurr[1];
                char newToAdd = (char) ('a' + newType);
                int newRem = newCurr[0];
                if (insertToQueue(pq, newRem, newType)) {
                    sb.append(newToAdd);
                    occurance = 1;
                    prevType = newType;
                }
                pq.add(curr);
            }
        }
        return sb.toString();
    }

    private boolean insertToQueue(PriorityQueue<int[]> pq, int rem, int type) {
        if (rem > 0) {
            pq.add(new int[]{rem - 1, type});
            return true;
        }
        return false;
    }
}
