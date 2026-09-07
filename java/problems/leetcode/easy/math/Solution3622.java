package problems.leetcode.easy.math;

/**
 * Problem: <a href="https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product">
 * check-divisibility-by-digit-sum-and-product</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3622 {
    public boolean checkDivisibility(int n) {
        int digitSum = 0;
        int digitProduct = 1;
        int copyN = n;
        while (copyN != 0) {
            digitSum += copyN % 10;
            digitProduct *= copyN % 10;
            copyN /= 10;
        }
        return n % (digitSum + digitProduct) == 0;
    }
}
