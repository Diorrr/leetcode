package problems.leetcode.medium.greedy;

/**
 * Problem: <a href="https://leetcode.com/problems/gas-station">
 * gas-station</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curr += gas[i] - cost[i];
            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }
        for (int i = 0; i < start; i++) {
            curr += gas[i] - cost[i];
            if (curr < 0) {
                return -1;
            }
        }
        return start;
    }
}
