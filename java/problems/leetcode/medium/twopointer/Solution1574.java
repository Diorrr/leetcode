package problems.leetcode.medium.twopointer;


/**
 * Problem: <a href="https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted">
 * shortest-subarray-to-be-removed-to-make-array-sorted</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int l = 0;
        while (l + 1 < arr.length && arr[l] <= arr[l + 1]) {
            l++;
        }
        int r = arr.length - 1;
        while (r - 1 >= 0 && arr[r - 1] <= arr[r]) {
            r--;
        }
        int res = Math.min(arr.length - 1 - l, r);
        int i = 0;
        int j = r;
        while (i <= l && j < arr.length) {
            if (arr[i] <= arr[j]) {
                res = Math.min(j - i - 1, res);
                i++;
            } else {
                j++;
            }
        }
        return Math.max(0, res);
    }
}
