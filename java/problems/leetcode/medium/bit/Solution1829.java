package problems.leetcode.medium.bit;


/**
 * Problem: <a href="https://leetcode.com/problems/maximum-xor-for-each-query">
 * maximum-xor-for-each-query</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1829 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            int num = 0;
            for (int j = 0; j < maximumBit; j++) {
                if ((xor >> j & 1) == 0) {
                    num += 1 << j;
                }
            }
            res[res.length - 1 - i] = num;
        }

        return res;
    }
}
