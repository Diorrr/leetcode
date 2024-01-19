package problems.medium.sorting;

/**
 * Problem: <a href="https://leetcode.com/problems/sort-colors">
 * sort-colors</a>
 * Time Complexity: O(N)
 * Space Complexity： O(1)
 */
class Solution75 {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < count[0]) {
                nums[i] = 0;
            } else if (i < count[0] + count[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
