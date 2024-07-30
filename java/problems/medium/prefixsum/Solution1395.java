package problems.medium.prefixsum;


/**
 * Problem: <a href="https://leetcode.com/problems/count-number-of-teams">
 * count-number-of-teams</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1395 {
    public int numTeams(int[] rating) {
        int res = 0;
        int[] bigger = new int[rating.length];
        int[] smaller = new int[rating.length];
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[i] < rating[j]) {
                    bigger[i]++;
                } else if (rating[i] > rating[j]) {
                    smaller[i]++;
                }
            }
        }

        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[i] < rating[j]) {
                    res += bigger[j];
                } else if (rating[i] > rating[j]) {
                    res += smaller[j];
                }
            }
        }

        return res;
    }
}
