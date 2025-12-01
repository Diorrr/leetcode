package problems.leetcode.medium.greedy;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/most-profit-assigning-work">
 * most-profit-assigning-work</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int res = 0;
        PriorityQueue<int[]> diffProf = new PriorityQueue<>((a, b) ->
                a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for (int i = 0; i < difficulty.length; i++) {
            diffProf.add(new int[]{difficulty[i], profit[i]});
        }
        Arrays.sort(worker);
        int currMaxProfit = 0;
        for (int work : worker) {
            while (!diffProf.isEmpty() && work >= diffProf.peek()[0]) {
                currMaxProfit = Math.max(diffProf.poll()[1], currMaxProfit);
            }
            res += currMaxProfit;
        }

        return res;
    }
}
