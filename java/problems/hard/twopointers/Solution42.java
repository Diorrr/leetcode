package problems.hard.twopointers;


/**
 * Problem: <a href="https://leetcode.com/problems/trapping-rain-water">
 * trapping-rain-water</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution42 {
    // sol from comments
    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }

        return res;
    }
}
