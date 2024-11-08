package problems.medium.sorting;


/**
 * Problem: <a href="https://leetcode.com/problems/find-if-array-can-be-sorted">
 * find-if-array-can-be-sorted</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3011 {
    public boolean canSortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[j - 1] > nums[j] && isEqualSetBits(nums[j - 1], nums[j])) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isEqualSetBits(int num1, int num2) {
        int count1 = 0;
        int count2 = 0;
        while (num1 != 0) {
            count1 += num1 % 2;
            num1 /= 2;
        }
        while (num2 != 0) {
            count2 += num2 % 2;
            num2 /= 2;
        }
        return count1 == count2;
    }
}
