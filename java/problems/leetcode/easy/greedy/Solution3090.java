package problems.leetcode.easy.greedy;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-length-substring-with-two-occurrences">
 * maximum-length-substring-with-two-occurrences</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3090 {
    public int maximumLengthSubstring(String s) {
        int res = 2;
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        int l = 0;
        for (int r = 0; r < chars.length; r++) {
            count[chars[r] - 'a']++;
            while (count[chars[r] - 'a'] > 2) {
                count[chars[l++] - 'a']--;
            }
            res = Math.max(r - l + 1, res);
        }
        return res;
    }

    public int maximumLengthSubstring2(String s) {
        int res = 2;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int[] count = new int[26];
            int currentLength = 0;
            for (int j = i; j < chars.length; j++) {
                count[chars[j] - 'a']++;
                if (count[chars[j] - 'a'] > 2) {
                    break;
                }
                currentLength = j - i + 1;
            }
            res = Math.max(currentLength, res);
        }

        return res;
    }
}
