package problems.easy;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array">
 * remove-duplicates-from-sorted-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int pos = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[pos - 1] != nums[i]) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        if (nums[nums.length - 2] != nums[nums.length - 1]) {
            nums[pos] = nums[nums.length - 1];
            pos++;
        }

        return pos;
    }
}
