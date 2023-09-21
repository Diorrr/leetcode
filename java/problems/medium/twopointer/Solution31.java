package problems.medium.twopointer;

/**
 * Problem: <a href="https://leetcode.com/problems/next-permutation">
 * next-permutation</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution31 {
    public void nextPermutation(int[] nums) {
        int k;
        for (k = nums.length - 2; k >= 0; k--) {
            if (nums[k] < nums[k + 1]) {
                break;
            }
        }
        if (k < 0) {
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
        } else {
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[k]) {
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = temp;
                    break;
                }
            }
            int l = k + 1;
            int r = nums.length - 1;
            while (l < r) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                r--;
                l++;
            }
        }
    }
}
