package problems.easy.sim;


/**
 * Problem: <a href="https://leetcode.com/problems/sum-of-digits-of-string-after-convert">
 * sum-of-digits-of-string-after-convert</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1945 {
    public int getLucky(String s, int k) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a' + 1;
            res += val / 10 + val % 10;
        }
        while (k != 1) {
            k--;
            res = getIntValue(res);
        }
        return res;
    }

    int getIntValue(int val) {
        int res = 0;
        while (val != 0) {
            res += val % 10;
            val /= 10;
        }
        return res;
    }
}
