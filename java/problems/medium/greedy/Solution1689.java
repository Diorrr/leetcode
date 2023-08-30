package problems.medium.greedy;

/**
 * Problem: <a href="https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers">
 * partitioning-into-minimum-number-of-deci-binary-numbers</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1689 {
    public int minPartitions(String n) {
        int res = 0;
        for (char c : n.toCharArray()) {
            res = Math.max(res, c - '0');
        }
        return res;
    }

    public int minPartitions2(String n) {
        return n.chars().max().getAsInt() - '0';
    }
}
