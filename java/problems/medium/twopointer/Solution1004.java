package problems.medium.twopointer;

/**
 * Problem: <a href="https://leetcode.com/problems/max-consecutive-ones-iii">
 * max-consecutive-ones-iii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int flip = k;
        int counter = 0;
        int l = 0, r = 0;
        while (l < nums.length && r < nums.length) {
            if (nums[r] == 1) {
                counter++;
                r++;
            } else if (flip > 0) {
                flip--;
                counter++;
                r++;
            } else {
                if (nums[l] == 0) {
                    flip++;
                }
                l++;
                counter--;
            }

            res = Math.max(res, counter);
        }

        return res;
    }
}
