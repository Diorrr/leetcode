package problems.leetcode.medium.math;

/**
 * Problem: <a href="https://leetcode.com/problems/construct-uniform-parity-array-ii">
 * construct-uniform-parity-array-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3876 {
    public boolean uniformArray(int[] nums1) {
        boolean isAllEvenPossible = true;
        int minOdd = Integer.MAX_VALUE;
        for (int num : nums1) {
            if (num == 1) {
                return true;
            }
            if (num % 2 == 1) {
                isAllEvenPossible = false;
                minOdd = Math.min(num, minOdd);
            }
        }
        if (isAllEvenPossible) {
            return true;
        }
        boolean isAllOddPossible = true;
        for (int num : nums1) {
            if (num % 2 == 0 && num < minOdd) {
                isAllOddPossible = false;
            }
        }
        return isAllOddPossible;
    }
}
