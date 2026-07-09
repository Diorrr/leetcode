package problems.leetcode.medium.counting;

/**
 * Problem: <a href="https://leetcode.com/problems/path-existence-queries-in-a-graph-i">
 * path-existence-queries-in-a-graph-i</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3532 {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        int[] grid = new int[n];
        int maxPos = 0;
        for (int i = 0; i < n; i++) {
            maxPos = Math.max(maxPos, i);
            for (; maxPos < n; maxPos++) {
                if (Math.abs(nums[i] - nums[maxPos]) > maxDiff) {
                    maxPos--;
                    break;
                }
            }
            grid[i] = maxPos;
        }
        for (int i = 0; i < queries.length; i++) {
            int start = Math.min(queries[i][0], queries[i][1]);
            int end = Math.max(queries[i][0], queries[i][1]);
            result[i] = getMaxPoint(grid, start, end);
            if (result[i]) {
                grid[start] = Math.max(grid[start], end);
            }
        }
        return result;
    }

    private boolean getMaxPoint(int[] grid, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (grid[start] == start) {
            return false;
        }
        return getMaxPoint(grid, grid[start], end);
    }
}
