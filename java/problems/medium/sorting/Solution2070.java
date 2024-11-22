package problems.medium.sorting;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem: <a href="https://leetcode.com/problems/most-beautiful-item-for-each-query">
 * most-beautiful-item-for-each-query</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] res = new int[queries.length];
        int[][] qSorted = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            qSorted[i] = new int[]{queries[i], i};
        }
        Arrays.sort(qSorted, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int pos = 0;
        int maxBeauty = 0;
        for (int[] query : qSorted) {
            int maxPrice = query[0];
            while (pos < items.length && items[pos][0] <= maxPrice) {
                maxBeauty = Math.max(items[pos][1], maxBeauty);
                pos++;
            }
            res[query[1]] = maxBeauty;
        }
        return res;
    }
}
