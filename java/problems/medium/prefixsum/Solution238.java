package problems.medium.prefixsum;

/**
 * Problem: <a href="https://leetcode.com/problems/product-of-array-except-self">
 * product-of-array-except-self</a>
 * Time Complexity: O(N)
 * Space Complexity：O(N)
 */
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = nums[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = product;
            product *= nums[i];
        }
        res[0] = 1;
        product = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] *= product;
            product *= nums[i];
        }
        return res;
    }

    public int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        int pref = 1;
        int suf = 1;
        for (int num : nums) {
            suf *= num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                suf = 1;
                for (int j = i + 1; j < nums.length; j++) {
                    suf *= nums[j];
                }
            } else {
                suf /= nums[i];
            }
            res[i] = suf * pref;
            pref *= nums[i];
        }

        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        int[] pref = new int[nums.length];
        int[] suf = new int[nums.length];
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            pref[i] = prod;
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];
            suf[i] = prod;
        }
        res[0] = suf[1];
        res[nums.length - 1] = pref[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = pref[i - 1] * suf[i + 1];
        }

        return res;
    }
}
