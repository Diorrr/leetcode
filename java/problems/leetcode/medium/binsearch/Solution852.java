package problems.leetcode.medium.binsearch;

/**
 * Problem: https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution852 {
    public int peakIndexInMountainArray(int[] arr) {
        int index = 0;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m - 1] < arr[m] && arr[m] > arr[m + 1]) {
                return m;
            } else if (arr[m - 1] < arr[m]) {
                l = m;
            } else {
                r = m;
            }
        }
        return index;
    }
}
