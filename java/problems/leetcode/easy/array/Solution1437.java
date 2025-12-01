package problems.leetcode.easy.array;

/**
 * Problem: <a href="https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away">
 * check-if-all-1s-are-at-least-length-k-places-away</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int posOne = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (posOne != -1 && i - posOne <= k) {
                    return false;
                }
                posOne = i;
            }
        }
        return true;
    }
}
