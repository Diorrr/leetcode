package problems.easy.sorting;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/set-mismatch">
 * set-mismatch</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution645 {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] count = new int[nums.length + 1];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 2) {
                res[0] = i;
            } else if (count[i] == 0) {
                res[1] = i;
            }
        }
        return res;
    }

    public int[] findErrorNums2(int[] nums) {
        int[] res = new int[2];
        Arrays.sort(nums);
        int toFind = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                res[0] = nums[i];
            }
            if (nums[i] == toFind) {
                toFind++;
            }
        }
        res[1] = toFind;
        return res;
    }
}
