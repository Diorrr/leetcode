package problems.leetcode.hard;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Problem: https://leetcode.com/problems/first-missing-positive/
 * Time Complexity: O(n)
 * Space Complexity：
 */
class Solution41 {
    // solution from comments: Cyclic sort
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int firstMissingPositive1(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 1; i <= max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return max > 0 ? max + 1 : 1;
    }
}
