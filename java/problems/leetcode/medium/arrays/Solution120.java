package problems.leetcode.medium.arrays;

import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/triangle">
 * triangle</a>
 * Time Complexity: O(n*m)
 * Space Complexity：
 */
class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }
            dp[i][i] = triangle.get(i).get(i) + dp[i - 1][i - 1];
        }
        for (int path : dp[triangle.size() - 1]) {
            res = Math.min(res, path);
        }
        return res;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(0) + triangle.get(i).get(j));
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i)
                            .set(j, triangle.get(i - 1).get(triangle.get(i - 1).size() - 1) + triangle.get(i).get(j));
                } else {
                    Integer minPath = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                    triangle.get(i).set(j, minPath + triangle.get(i).get(j));
                }
            }
        }

        return triangle.get(triangle.size() - 1).stream().min(Integer::compareTo).get();
    }
}
