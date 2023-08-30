package problems.medium.twopointer;

/**
 * Problem: https://leetcode.com/problems/container-with-most-water/
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution11 {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}
