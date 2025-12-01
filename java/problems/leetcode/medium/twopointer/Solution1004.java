package problems.leetcode.medium.twopointer;

/**
 * Problem: <a href="https://leetcode.com/problems/max-consecutive-ones-iii">
 * max-consecutive-ones-iii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        for (r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                k--;
            }
            if (k < 0 && nums[l++] == 0) {
                k++;
            }
        }

        return r - l;
    }

    public int longestOnes2(int[] nums, int k) {
        int res = 0;
        int counter = 0;
        int l = 0, r = 0;
        while (l < nums.length && r < nums.length) {
            if (nums[r] == 1) {
                counter++;
                r++;
            } else if (k > 0) {
                k--;
                counter++;
                r++;
            } else {
                if (nums[l] == 0) {
                    k++;
                }
                l++;
                counter--;
            }

            res = Math.max(res, counter);
        }

        return res;
    }
}
