package problems.easy.array;


/**
 * Problem: <a href="https://leetcode.com/problems/three-consecutive-odds">
 * three-consecutive-odds</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] % 2 == 1 && arr[i - 1] % 2 == 1 && arr[i - 2] % 2 == 1) {
                return true;
            }
        }
        return false;
    }
}
