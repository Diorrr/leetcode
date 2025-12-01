package problems.leetcode.easy.array;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-element">
 * remove-element</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution27 {
    public int removeElement(int[] nums, int val) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pos] = nums[i];
                pos++;
            }
        }

        return pos;
    }
}
