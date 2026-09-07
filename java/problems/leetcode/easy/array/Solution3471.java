package problems.leetcode.easy.array;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/find-the-largest-almost-missing-integer">
 * find-the-largest-almost-missing-integer</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3471 {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[51];
        for (int num : nums) {
            count[num]++;
        }
        if (k == 1) {
            for (int i = 50; i >= 0; i--) {
                if (count[i] == 1) {
                    return i;
                }
            }
        } else if (n == k) {
            for (int i = 50; i >= 0; i--) {
                if (count[i] != 0) {
                    return i;
                }
            }
        } else {
            int countFirst = count[nums[0]];
            int countLast = count[nums[n - 1]];
            if (countFirst == 1 && countLast == 1) {
                return Math.max(nums[0], nums[nums.length - 1]);
            } else if (countFirst == 1 || countLast == 1) {
                return countFirst == 1 ? nums[0] : nums[nums.length - 1];
            }
        }
        return -1;
    }

    public int largestInteger2(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        } else if (k == 1) {
            Arrays.sort(nums);
            if (nums[nums.length - 1] != nums[nums.length - 2]) {
                return nums[nums.length - 1];
            }
            for (int i = nums.length - 2; i > 0; i--) {
                if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                    return nums[i];
                }
            }
            if (nums[0] != nums[1]) {
                return nums[0];
            }
        } else if (nums.length == k) {
            return Arrays.stream(nums).max().getAsInt();
        } else {
            int countFirst = 0;
            int countLast = 0;
            for (int num : nums) {
                if (num == nums[0]) {
                    countFirst++;
                }
                if (num == nums[nums.length - 1]) {
                    countLast++;
                }
            }
            if (countFirst == 1 && countLast == 1) {
                return Math.max(nums[0], nums[nums.length - 1]);
            } else if (countFirst == 1 || countLast == 1) {
                return countFirst == 1 ? nums[0] : nums[nums.length - 1];
            }
        }
        return -1;
    }
}
