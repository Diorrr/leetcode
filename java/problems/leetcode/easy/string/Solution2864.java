package problems.leetcode.easy.string
        ;


/**
 * Problem: <a href="https://leetcode.com/problems/maximum-odd-binary-number">
 * maximum-odd-binary-number</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2864 {
    public String maximumOddBinaryNumber(String s) {
        char[] chars = new char[s.length()];
        char[] sChars = s.toCharArray();
        int pos = 0;

        for (int i = 0; i < sChars.length; i++) {
            chars[i] = '0';
            if (sChars[i] == '1') {
                chars[pos++] = '1';
            }
        }
        chars[pos - 1] = '0';
        chars[s.length() - 1] = '1';

        return String.valueOf(chars);
    }

    public String maximumOddBinaryNumber2(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        StringBuilder res = new StringBuilder();
        res.append("1".repeat(count - 1));
        res.append("0".repeat(s.length() - count));
        res.append("1".repeat(1));
        return res.toString();
    }
}
