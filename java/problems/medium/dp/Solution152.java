package problems.medium.dp;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-product-subarray">
 * maximum-product-subarray</a>
 * Time Complexity: O(n)
 * Space Complexity：O(1)
 */
class Solution152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int leftProd = 1, rightProd = 1;

        for (int i = 0; i < nums.length; i++) {
            leftProd = (leftProd == 0 ? 1 : leftProd) * nums[i];
            rightProd = (rightProd == 0 ? 1 : rightProd) * nums[nums.length - 1 - i];
            max = Math.max(max, Math.max(leftProd, rightProd));
        }

        return max;
    }
}
