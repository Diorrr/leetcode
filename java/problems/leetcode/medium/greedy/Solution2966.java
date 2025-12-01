package problems.leetcode.medium.greedy;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/divide-array-into-arrays-with-max-difference">
 * divide-array-into-arrays-with-max-difference</a>
 * Time Complexity: O(NlogN)
 * Space Complexity：O(N)
 */
class Solution2966 {
    public int[][] divideArray(int[] nums, int k) {
        int[][] res = new int[nums.length / 3][3];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i] + k >= nums[i + 2]) {
                res[i / 3][0] = nums[i];
                res[i / 3][1] = nums[i + 1];
                res[i / 3][2] = nums[i + 2];
            } else {
                return new int[0][];
            }
        }

        return res;
    }
}
