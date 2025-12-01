package problems.leetcode.easy.array;

/**
 * Problem: <a href="https://leetcode.com/problems/1-bit-and-2-bit-characters">
 * 1-bit-and-2-bit-characters</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution717 {
    public boolean isOneBitCharacter(int[] bits) {
        return !isTwoCharacter(bits, 0);
    }

    private boolean isTwoCharacter(int[] bits, int index) {
        if (index >= bits.length - 1) {
            return false;
        }
        if (bits[index] == 1 && index == bits.length - 2) {
            return true;
        }
        if (bits[index] == 0) {
            return isTwoCharacter(bits, index + 1);
        }
        return isTwoCharacter(bits, index + 2);
    }

    public boolean isOneBitCharacter1(int[] bits) {
        boolean[] dp = new boolean[bits.length + 1];
        if (bits.length == 1) {
            return true;
        }
        dp[0] = true;
        for (int i = bits[0] == 0 ? 1 : 2; i < bits.length; i++) {
            if (bits[i] == 1 && (!dp[i - 1] || (bits[i-1] == 0 && dp[i-1]))) {
                dp[i] = true;
            }
            if (bits[i]== 0 && (bits[i-1] == 0 || !dp[i-1])){
                dp[i] = true;
            }
        }
        return dp[bits.length - 1];
    }
}
