package problems.leetcode.medium.dfs;


/**
 * Problem: <a href="https://leetcode.com/problems/most-stones-removed-with-same-row-or-column">
 * most-stones-removed-with-same-row-or-column</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution947 {
    public int removeStones(int[][] stones) {
        int numOfIslands = 0;
        boolean[] used = new boolean[stones.length];
        for (int i = 0; i < stones.length; i++) {
            if (!used[i]) {
                dfs(i, used, stones);
                numOfIslands++;
            }
        }
        return stones.length - numOfIslands;
    }

    private void dfs(int index, boolean[] used, int[][] stones) {
        used[index] = true;
        for (int i = 0; i < stones.length; i++) {
            if (!used[i] && (stones[index][0] == stones[i][0] || stones[index][1] == stones[i][1])) {
                dfs(i, used, stones);
            }
        }
    }
}
