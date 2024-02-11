package problems.medium.dp;

/**
 * Problem: https://leetcode.com/problems/palindromic-substrings/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution647 {
    // solution from comments
    public int countSubstrings(String s) {
        char[] sChar = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = (sChar[i] == sChar[j]) && (i - 1 < j + 1 || dp[i - 1][j + 1]);
                if (dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }

    Integer count = 0;

    public int countSubstrings1(String s) {
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            countFrom(sChar, i, i);
            countFrom(sChar, i, i + 1);
        }

        return count;
    }

    private void countFrom(char[] s, int i, int j) {
        while (i >= 0 && j < s.length && s[i] == s[j]) {
            count++;
            i--;
            j++;
        }
    }

    public int countSubstrings2(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && isPalindrome(s.substring(j, i + 1))) {
                    res++;
                }
            }
        }
        return res;
    }

    boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
