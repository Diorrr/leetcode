package problems.leetcode.medium.dp;

/**
 * Problem: <a href="https://leetcode.com/problems/predict-the-winner">
 * predict-the-winner</a>
 * Time Complexity: O(N^2)
 * Space Complexity：
 */
class Solution486 {
    public boolean predictTheWinner(int[] nums) {
        int[] pref = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pref[i + 1] = nums[i] + pref[i];
        }
        int[][] score = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            score[i][i] = nums[i];
        }
        for (int len = 1; len < nums.length; len++) {
            for (int i = 0; i + len < nums.length; i++) {
                score[i][i + len] = pref[i + len + 1] - pref[i] - Math.min(score[i + 1][i + len], score[i][i + len - 1]);
            }
        }

        return score[0][nums.length - 1] * 2 >= pref[nums.length];
    }
}
