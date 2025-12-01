package problems.leetcode.easy;

/**
 * Problem: https://leetcode.com/problems/reverse-bits/
 * Time Complexity:
 * Space Complexity：
 */
class Solution190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (1L << (31 - i)) * (((n & (1L << i)) != 0) ? 1 : 0);
        }

        return res;
    }

    public int reverseBits2(int n) {
        int res = 0;
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            number.append(((n & (1L << i)) != 0) ? "1" : "0");
        }
        number = number.reverse();
        for (int i = 0; i < 32; i++) {
            res += (1L << i) * (number.toString().toCharArray()[i] == '1' ? 1 : 0);
        }

        return res;
    }
}
