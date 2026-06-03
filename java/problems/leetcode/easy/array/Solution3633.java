package problems.leetcode.easy.array;

/**
 * Problem: <a href="https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i">
 * earliest-finish-time-for-land-and-water-rides-i</a>
 * Time Complexity: O(n*m)
 * Space Complexity：
 */
class Solution3633 {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(findMinTime(waterStartTime, waterDuration, landStartTime, landDuration),
                        findMinTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }

    private int findMinTime(int[] cat1, int[] dur1, int[] cat2, int[] dur2) {
        int finish1 = Integer.MAX_VALUE;
        int finish2 = Integer.MAX_VALUE;
        for (int i = 0; i < cat1.length; i++) {
            finish1 = Math.min(finish1, cat1[i] + dur1[i]);
        }
        for (int j = 0; j < cat2.length; j++) {
            finish2 = Math.min(finish2, Math.max(finish1, cat2[j]) + dur2[j]);
        }
        return finish2;
    }

    private int findMinTime2(int[] cat1, int[] dur1, int[] cat2, int[] dur2) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < cat1.length; i++) {
            int finish1 = cat1[i] + dur1[i];
            for (int j = 0; j < cat2.length; j++) {
                ans = Math.min(ans, Math.max(finish1, cat2[j]) + dur2[j]);
            }
        }
        return ans;
    }
}
