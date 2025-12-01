package problems.leetcode.easy.string;


/**
 * Problem: <a href="https://leetcode.com/problems/crawler-log-folder">
 * crawler-log-folder</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1598 {
    public int minOperations(String[] logs) {
        int res = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (res > 0) {
                    res--;
                }
            } else if (!log.equals("./")) {
                res++;
            }
        }

        return res;
    }
}
