package problems.medium.bit;


/**
 * Problem: <a href="https://leetcode.com/problems/minimum-array-end">
 * minimum-array-end</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3133 {
    public long minEnd(int n, int x) {
        long res = x;
        while (n-- > 1) {
            res = (res + 1) | x;
        }

        return res;
    }
}
