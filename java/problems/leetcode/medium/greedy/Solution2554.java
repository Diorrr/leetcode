package problems.leetcode.medium.greedy;


/**
 * Problem: <a href="https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i">
 * maximum-number-of-integers-to-choose-from-a-range-i</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        int count = 0;
        boolean[] used = new boolean[10000 + 1];
        for (int ban : banned) {
            used[ban] = true;
        }
        for (int i = 1; i <= n && maxSum - i >= 0; i++) {
            if (!used[i]) {
                maxSum -= i;
                count++;
            }
        }

        return count;
    }
}
