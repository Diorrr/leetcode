package problems.leetcode.easy.dp;

/**
 * Problem: <a href="https://leetcode.com/problems/climbing-stairs">
 * climbing-stairs</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution70 {
    public int climbStairs(int n) {
        int[]array = new int[46];
        array[1]=1;
        array[2]=2;
        array[3]=3;
        for (int i = 4; i <= n; i++) {
            array[i]=array[i-1]+array[i-2];
        }
        return array[n];
    }

    // solution without array with 3 additional variables
    public int climbStairs2(int n) {
        int stepOne = 1;
        int stepTwo = 2;
        int stepN = n;
        for (int i = 3; i <= n; i++) {
            stepN = stepOne + stepTwo;
            stepOne = stepTwo;
            stepTwo = stepN;
        }

        return stepN;
    }
}
