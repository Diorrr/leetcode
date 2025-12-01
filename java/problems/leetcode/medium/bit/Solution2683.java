package problems.leetcode.medium.bit;


/**
 * Problem: <a href="https://leetcode.com/problems/neighboring-bitwise-xor">
 * neighboring-bitwise-xor</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2683 {
    public boolean doesValidArrayExist(int[] derived) {
        int res = 0;
        for (int num : derived) {
            res ^= num;
        }
        return res == 0;
    }
}
