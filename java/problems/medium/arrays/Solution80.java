package problems.medium.arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii">
 * remove-duplicates-from-sorted-array-ii</a>
 * Time Complexity: O(n)
 * Space Complexity：
 */
class Solution80 {
    public int removeDuplicates(int[] nums) {
        int res = nums.length;
        int pow = (int) Math.pow(10, 4);
        int[] count = new int[2 * pow + 2];
        int posToPut = 0;
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] + pow]++;
            if (count[nums[i] + pow] > 2) {
                res--;
            } else {
                nums[posToPut] = nums[i];
                posToPut++;
            }
        }

        return res;
    }
}
