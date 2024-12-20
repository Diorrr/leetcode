package problems.medium.greedy;


import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/max-chunks-to-make-sorted">
 * max-chunks-to-make-sorted</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution769 {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        boolean[] used = new boolean[arr.length];
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            pos.put(arr[i], i);
        }
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                int end = pos.get(i);
                for (int j = start; j <= end; j++) {
                    end = Math.max(arr[j], end);
                    used[arr[j]] = true;
                }
                res++;
            }
        }

        return res;
    }
}
