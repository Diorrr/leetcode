package problems.leetcode.easy.math;


/**
 * Problem: <a href="https://leetcode.com/problems/time-needed-to-buy-tickets">
 * time-needed-to-buy-tickets</a>
 * Time Complexity: O(N)
 * Space Complexity： O(1)
 */
class Solution2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int lessThanMin = 0;
        for (int i = 0; i < k; i++) {
            if (tickets[i] < tickets[k]) {
                lessThanMin += tickets[k] - tickets[i];
            }
        }
        for (int i = k + 1; i < tickets.length; i++) {
            if (tickets[i] < tickets[k]) {
                lessThanMin += tickets[k] - tickets[i] - 1;
            }
        }

        return (tickets[k] - 1) * tickets.length + k + 1 - lessThanMin;
    }
}
