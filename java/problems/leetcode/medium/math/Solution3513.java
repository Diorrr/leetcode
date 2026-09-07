package problems.leetcode.medium.math;

/**
 * Problem: <a href="https://leetcode.com/problems/number-of-unique-xor-triplets-i">
 * number-of-unique-xor-triplets-i</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3513 {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int powOfTwo = 1 << i;
            if (powOfTwo >= n) {
                return powOfTwo;
            }
        }
        return n == 1 ? 1 : 2;
    }
}
