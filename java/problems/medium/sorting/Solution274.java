package problems.medium.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/h-index">
 * h-index</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution274 {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length + 1];
        for (int citation : citations) {
            if (citation >= count.length) {
                count[count.length - 1]++;
            } else {
                count[citation]++;
            }
        }
        int total = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }

        return 0;
    }

    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        for (int i = 1; i <= citations.length; i++) {
            if (citations[citations.length - i] >= i) {
                res = i;
            }
        }

        return res;
    }

    public int hIndex2(int[] citations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int citation : citations) {
            queue.add(citation);
        }
        while (!queue.isEmpty()) {
            if (queue.peek() >= queue.size()) {
                return queue.size();
            }
            queue.poll();
        }

        return 0;
    }
}
