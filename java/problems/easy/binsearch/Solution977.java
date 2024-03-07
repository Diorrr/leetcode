package problems.easy.binsearch;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/squares-of-a-sorted-array/
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int pos = findPosition(nums);

        res[0] = nums[pos] * nums[pos];
        int lm = pos - 1, rm = pos + 1;
        for (int i = 1; i < nums.length; i++) {
            if (lm >= 0 && rm <= nums.length - 1) {
                if (Math.abs(nums[lm]) < Math.abs(nums[rm])) {
                    res[i] = nums[lm] * nums[lm];
                    lm--;
                } else {
                    res[i] = nums[rm] * nums[rm];
                    rm++;
                }
            } else if (lm >= 0) {
                res[i] = nums[lm] * nums[lm];
                lm--;
            } else {
                res[i] = nums[rm] * nums[rm];
                rm++;
            }
        }
        return res;
    }

    private int findPosition(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == 0) {
                break;
            } else if (nums[m] < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (m + 1 < nums.length && Math.abs(nums[m]) > Math.abs(nums[m + 1])) {
            return m + 1;
        }
        if (m - 1 >= 0 && Math.abs(nums[m - 1]) < Math.abs(nums[m])) {
            return m - 1;
        }
        return m;
    }

    public int[] sortedSquares1(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length == 1) {
            res[0] = nums[0] * nums[0];
            return res;
        }

        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                pos = i;
                break;
            } else if (nums[i] < 0 && nums[pos] < nums[i]) {
                pos = i;
            } else if (i - 1 >= 0 && nums[i - 1] < 0 && nums[i] > 0) {
                if (Math.abs(nums[i - 1]) < Math.abs(nums[i])) {
                    pos = i - 1;
                } else {
                    pos = i;
                }
                break;
            }
        }
        res[0] = nums[pos] * nums[pos];
        int lm = pos - 1, rm = pos + 1;
        for (int i = 1; i < nums.length; i++) {
            if (lm >= 0 && rm <= nums.length - 1) {
                if (Math.abs(nums[lm]) < Math.abs(nums[rm])) {
                    res[i] = nums[lm] * nums[lm];
                    lm--;
                } else {
                    res[i] = nums[rm] * nums[rm];
                    rm++;
                }
            } else if (lm >= 0) {
                res[i] = nums[lm] * nums[lm];
                lm--;
            } else {
                res[i] = nums[rm] * nums[rm];
                rm++;
            }
        }
        return res;
    }

    public int[] sortedSquares2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
