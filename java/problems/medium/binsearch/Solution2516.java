package problems.medium.binsearch;


/**
 * Problem: <a href="https://leetcode.com/problems/take-k-of-each-character-from-left-and-right">
 * take-k-of-each-character-from-left-and-right</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2516 {
    public int takeCharacters(String s, int k) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            boolean isPossible = isPossible(chars, m, k);
            if (isPossible) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l >= k * 3 && l < chars.length ? l : -1;
    }

    private boolean isPossible(char[] chars, int len, int k) {
        int[] count = new int[3];
        for (int i = 0; i <= len; i++) {
            count[chars[i] - 'a']++;
        }
        if (count[0] >= k && count[1] >= k && count[2] >= k) {
            return true;
        }
        for (int i = 0; i <= len; i++) {
            count[chars[len - i] - 'a']--;
            count[chars[chars.length - 1 - i] - 'a']++;
            if (count[0] >= k && count[1] >= k && count[2] >= k) {
                return true;
            }
        }
        return false;
    }
}
