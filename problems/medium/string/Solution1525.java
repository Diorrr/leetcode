package problems.medium.string;

/**
 * Problem: <a href="https://leetcode.com/problems/number-of-good-ways-to-split-a-string/">
 * number-of-good-ways-to-split-a-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1525 {
    public int numSplits(String s) {
        int n = s.length();
        long[] occurLeft = new long[n];
        long[] occurRight = new long[n];
        int[] freqLeft = new int[26];
        int[] freqRight = new int[26];
        int distinctLeft = 0;
        int distinctRight = 0;
        char[] splitS = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (freqRight[splitS[i] - 'a'] == 0) {
                distinctRight++;
            }
            freqRight[splitS[i] - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (freqLeft[splitS[i] - 'a'] == 0) {
                distinctLeft++;
            }
            if (freqRight[splitS[i] - 'a'] == 1) {
                distinctRight--;
            }
            freqLeft[splitS[i] - 'a']++;
            freqRight[splitS[i] - 'a']--;

            occurLeft[i] = distinctLeft;
            occurRight[i] = distinctRight;
        }


        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (occurLeft[i] == occurRight[i]) {
                res++;
            }
        }

        return res;
    }
}
