package problems.leetcode.easy.math;


/**
 * Problem: <a href="https://leetcode.com/problems/find-the-pivot-integer">
 * find-the-pivot-integer</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2485 {

    // (1+x)*x=(x+n)*(n-x+1)
    // x^2=-x^2+n^2+n
    // x^2=(n^2+n)/2
    public int pivotInteger(int n) {
        int squareX = n * n + n;
        int sqrtSquareX = (int) Math.sqrt(squareX / 2);
        if (squareX % 2 == 0 && (int) (Math.pow(sqrtSquareX, 2.0)) == squareX / 2) {
            return sqrtSquareX;
        }
        return -1;
    }

    public int pivotInteger2(int n) {
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] += prefix[i - 1] + i;
        }
        for (int i = 0; i < n; i++) {
            if (prefix[i] + i + 1 == prefix[n] - prefix[i]) {
                return i + 1;
            }
        }
        return -1;
    }
}

