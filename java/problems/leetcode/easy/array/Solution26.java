package problems.leetcode.easy.array;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array">
 * remove-duplicates-from-sorted-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution26 {
    public int removeDuplicates(int[] nums) {
        int pos = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[pos - 1] != nums[i]) {
                nums[pos] = nums[i];
                pos++;
            }
        }

        return pos;
    }
}
