package problems.easy.array;


/**
 * Problem: <a href="https://leetcode.com/problems/monotonic-array">
 * monotonic-array</a>
 * Time Complexity: O(n)
 * Space Complexity： O(1)
 */
class Solution896 {
    public boolean isMonotonic(int[] nums) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                isIncreasing = false;
                break;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                isDecreasing = false;
                break;
            }
        }

        return isIncreasing || isDecreasing;
    }
}
