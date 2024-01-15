package problems.medium.twopointer;

/**
 * Problem: <a href="https://leetcode.com/problems/container-with-most-water">
 * container-with-most-water</a>
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution11 {

    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        int length = height.length;
        int currentArea;
        while (length-- != 0) {
            if (height[l] <= height[r]) {
                currentArea = length * height[l];
                l++;
            } else {
                currentArea = length * height[r];
                r--;
            }
            if (currentArea > res) {
                res = currentArea;
            }
        }

        return res;
    }

    public int maxArea2(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
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
