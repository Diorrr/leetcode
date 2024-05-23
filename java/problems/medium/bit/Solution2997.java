package problems.medium.bit;


/**
 * Problem: <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k">
 * minimum-number-of-operations-to-make-array-xor-equal-to-k</a>
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution2997 {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }

        while (xor != 0 || k != 0) {
            count += (xor % 2 == k % 2) ? 0 : 1;
            xor /= 2;
            k /= 2;
        }
        return count;
    }
}
