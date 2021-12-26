package problems;

/**
 * Problem: https://leetcode.com/problems/climbing-stairs/
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution70 {
    public int climbStairs(int n) {
        int[] array = new int[46];
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;
        for (int i = 4; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
