package problems.medium;

/**
 * Problem: https://leetcode.com/problems/subarray-product-less-than-k/
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution713 {
    //from solution section
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int res = 0, balance = 1, l = 0;
        for (int i = 0; i < nums.length; i++) {
            balance *= nums[i];
            while (balance >= k) {
                balance /= nums[l++];
            }
            res += i - l + 1;
        }

        return res;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int res = 0;
        int balance = 1;
        for (int i = 0; i < nums.length; i++) {
            balance = 1;
            for (int j = i; j < nums.length; j++) {
                balance *= nums[j];
                if (balance < k) {
                    res++;
                } else {
                    break;
                }
            }
        }

        return res;
    }
}
