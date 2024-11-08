package problems.medium.bit;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero">
 * largest-combination-with-bitwise-and-greater-than-zero</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2275 {
    public int largestCombination(int[] candidates) {
        int res = 0;
        for (int i = 0; i < 30; i++) {
            int cur = 0;
            for (int candidate : candidates) {
                cur += candidate >> i & 1;
            }
            res = Math.max(cur, res);
        }

        return res;
    }

    public int largestCombination2(int[] candidates) {
        int[] bitsCount = new int[30];
        for (int candidate : candidates) {
            char[] bits = Integer.toBinaryString(candidate).toCharArray();
            for (int i = 0; i < bits.length; i++) {
                bitsCount[i] += bits[bits.length - i - 1] - '0';
            }
        }

        return Arrays.stream(bitsCount).max().getAsInt();
    }

    public int largestCombination3(int[] candidates) {
        int[] bits = new int[30];
        for (int candidate : candidates) {
            int pos = 0;
            while (candidate != 0) {
                bits[pos] += candidate % 2;
                candidate /= 2;
                pos++;
            }
        }

        return Arrays.stream(bits).max().getAsInt();
    }
}
