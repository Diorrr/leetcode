package problems.leetcode.easy.graph;


/**
 * Problem: <a href="https://leetcode.com/problems/find-center-of-star-graph">
 * find-center-of-star-graph</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1791 {
    public int findCenter(int[][] edges) {
        int res = 0;
        int max = 0;
        int[] count = new int[edges.length+1];
        for (int[] edge : edges) {
            count[edge[0]]++;
            count[edge[1]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                res = i;
            }
        }

        return res;
    }
}
