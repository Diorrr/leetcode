package problems.leetcode.easy.array;

/**
 * Problem: <a href="https://leetcode.com/problems/find-missing-and-repeated-values">
 * find-missing-and-repeated-values</a>
 * Time Complexity: O(n)
 * Space Complexity： O(n)
 */
class Solution2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int missing = (1 + n * n) * n * n / 2;
        int rep = 0;
        boolean[] used = new boolean[n * n + 1];
        for (int[] row : grid) {
            for (int num : row) {
                if (used[num]) {
                    rep = num;
                } else {
                    missing -= num;
                }
                used[num] = true;
            }
        }
        return new int[]{rep, missing};
    }
}
