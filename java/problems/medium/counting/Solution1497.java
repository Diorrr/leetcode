package problems.medium.counting;


/**
 * Problem: <a href="https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k">
 * check-if-array-pairs-are-divisible-by-k</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1497 {
    public boolean canArrange(int[] arr, int k) {
        int[] rem = new int[k];
        for (int num : arr) {
            rem[((num % k) + k) % k]++;
        }
        if (rem[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i < (k + 1) / 2; i++) {
            if (rem[i] != rem[k - i]) {
                return false;
            }
        }
        return true;
    }
}
