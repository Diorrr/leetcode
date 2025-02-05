package problems.easy.string;

/**
 * Problem: <a href="https://leetcode.com/problems/roman-to-integer">
 * roman-to-integer</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution13 {
    public int romanToInt(String s) {
        int res = 0;
        int prev = 0;
        char[] chars = s.toCharArray();
        int[] charValues = new int[26];
        charValues['I' - 'A'] = 1;
        charValues['V' - 'A'] = 5;
        charValues['X' - 'A'] = 10;
        charValues['L' - 'A'] = 50;
        charValues['C' - 'A'] = 100;
        charValues['D' - 'A'] = 500;
        charValues['M' - 'A'] = 1000;
        for (int i = chars.length - 1; i >= 0; i--) {
            int val = charValues[chars[i] - 'A'];
            if (val >= prev) {
                res += val;
                prev = val;
            } else {
                res -= val;
            }
        }
        return res;
    }
}
