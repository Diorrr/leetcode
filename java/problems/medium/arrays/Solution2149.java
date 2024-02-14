package problems.medium.arrays;


/**
 * Problem: <a href="https://leetcode.com/problems/rearrange-array-elements-by-sign">
 * rearrange-array-elements-by-sign</a>
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution2149 {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int posInd = 0;
        int negInd = 1;
        for (int num : nums) {
            if (num > 0) {
                res[posInd] = num;
                posInd += 2;
            } else {
                res[negInd] = num;
                negInd += 2;
            }
        }

        return res;
    }

    public int[] rearrangeArray2(int[] nums) {
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];
        int posInd = 0;
        int negInd = 0;
        for (int num : nums) {
            if (num > 0) {
                pos[posInd++] = num;
            } else {
                neg[negInd++] = num;
            }
        }
        posInd = 0;
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = pos[posInd++];
        }
        negInd = 0;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = neg[negInd++];
        }

        return nums;
    }
}
