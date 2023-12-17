package problems.medium.window;

/**
 * Problem: <a href="https://leetcode.com/problems/longest-palindromic-substring">
 * longest-palindromic-substring</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        String res = String.valueOf(chars[0]);
        for (int i = 1; i < chars.length - 1; i++) {
            int l = i;
            int r = i;
            while (l - 1 >= 0 && r + 1 < chars.length && chars[l - 1] == chars[r + 1]) {
                l--;
                r++;
            }
            if (r - l + 1 > res.length()) {
                res = s.substring(l, r + 1);
            }
        }

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                int l = i;
                int r = i - 1;
                while (l - 1 >= 0 && r + 1 < chars.length && chars[l - 1] == chars[r + 1]) {
                    l--;
                    r++;
                }
                if (r - l + 1 > res.length()) {
                    res = s.substring(l, r + 1);
                }
            }
        }

        return res;
    }

    // dp solution from comments
    public String longestPalindrome1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int startRes = 0;
        int resLength = 1;
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int end = 0; end < n; end++) {
            for (int start = end - 1; start >= 0; start--) {
                if (chars[start] == chars[end] && (end - start == 1 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                    if (end - start + 1 > resLength) {
                        startRes = start;
                        resLength = end - start + 1;
                    }
                }
            }
        }

        return s.substring(startRes, startRes + resLength);
    }

    public String longestPalindrome2(String s) {
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j + i < s.length() + 1; j++) {
                String substring = s.substring(j, j + i);
                if (isPalindrome(substring)) {
                    return substring;
                }
            }
        }

        return s;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }
}
