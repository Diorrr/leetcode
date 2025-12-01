package problems.leetcode.easy.array;


/**
 * Problem: <a href="https://leetcode.com/problems/find-the-town-judge">
 * find-the-town-judge</a>
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution997 {
    public int findJudge(int n, int[][] trust) {
        int[] countTrustedBy = new int[n + 1];
        int[] countTrustTo = new int[n + 1];
        for (int[] pair : trust) {
            countTrustedBy[pair[1]]++;
            countTrustTo[pair[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (countTrustedBy[i] == n - 1 && countTrustTo[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
