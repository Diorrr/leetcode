package problems.medium.arrays;


/**
 * Problem: <a href="https://leetcode.com/problems/longest-turbulent-subarray">
 * longest-turbulent-subarray</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution978 {
    public int maxTurbulenceSize(int[] arr) {
        return Math.max(calc(arr, 0), calc(arr, 1));
    }

    private int calc(int[] arr, int even) {
        int res = 1;
        int temp = 1;
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == even && arr[i - 1] > arr[i]) {
                temp++;
            } else if (i % 2 != even && arr[i - 1] < arr[i]) {
                temp++;
            } else {
                res = Math.max(res, temp);
                temp = 1;
            }
        }
        res = Math.max(res, temp);

        return res;
    }
}
