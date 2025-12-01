package problems.leetcode.easy.dp;

/**
 * Problem: https://leetcode.com/problems/fibonacci-number/
 * Time Complexity:
 * Space Complexity：
 */
class Solution509 {
    public int fib(int n) {
        int[] fibonacciNumbers = new int[31];
        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i - 2] + fibonacciNumbers[i - 1];
        }
        return fibonacciNumbers[n];
    }

    public int fib2(int n) {
        int[] fibonacciNumbers = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040};
        return fibonacciNumbers[n];
    }
}
