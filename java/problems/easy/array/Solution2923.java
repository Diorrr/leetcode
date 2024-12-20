package problems.easy.array;


/**
 * Problem: <a href="https://leetcode.com/problems/find-champion-i">
 * find-champion-i</a>
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution2923 {
    public int findChampion(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            int countZero = 0;
            for (int j = 0; j < grid.length && countZero < 2; j++) {
                countZero += 1-grid[i][j];
            }
            if (countZero < 2){
                return i;
            }
        }
        return 0;
    }
}
