package problems.leetcode.medium.sim;


/**
 * Problem: <a href="https://leetcode.com/problems/find-kth-bit-in-nth-binary-string">
 * find-kth-bit-in-nth-binary-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1545 {
    public char findKthBit(int n, int k) {
        boolean curr = false;
        int len = 1;
        for (int i = 0; i < n; i++) {
            len = len * 2 + 1;
        }
        for (int i = 1; i < n; i++) {
            if ((len + 1) / 2 == k) {
                return curr ? '0' : '1';
            } else if ((len + 1) / 2 < k) {
                k = len - k + 1;
                curr = !curr;
            }
            len = (len - 1) / 2;
        }
        char res = k == 1 ? '0' : '1';
        if (curr) {
            res = res == '0' ? '1' : '0';
        }
        return res;
    }
}
