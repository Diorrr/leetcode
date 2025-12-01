package problems.leetcode.medium.twopointer;


/**
 * Problem: <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element">
 * longest-subarray-of-1s-after-deleting-one-element</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1493 {
    public int longestSubarray(int[] nums) {
        int res = 0;
        int start = 0;
        int zeroCount = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount--;
            }
            while (zeroCount < 0) {
                if (nums[start] == 0) {
                    zeroCount++;
                }
                start++;
            }
            res = Math.max(res, i - start);
        }

        return res;
    }

    public int longestSubarray2(int[] nums) {
        int res = 0;
        int l = 0;
        int r = 0;
        boolean isDeleted = false;
        int balance = 0;
        while (l < nums.length && r < nums.length) {
            if (nums[r] == 1) {
                balance++;
                r++;
            } else if (!isDeleted) {
                balance++;
                r++;
                isDeleted = true;
            } else {
                if (nums[l] == 0) {
                    isDeleted = false;
                }
                balance--;
                l++;
            }
            res = Math.max(balance, res);
        }

        return Math.max(0, res - 1);
    }
}
