package problems.leetcode.medium.math;


/**
 * Problem: <a href="https://leetcode.com/problems/reverse-integer">
 * reverse-integer</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution7 {
    public int reverse(int x) {
        if (x == Math.pow(2, 31)) {
            return 0;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(Math.abs(x));
        builder.reverse();

        try {
            return ((int) Math.signum(x)) * Integer.parseInt(builder.toString());
        } catch (Exception e) {
            return 0;
        }
    }
}
