package problems.medium.arrays;


/**
 * Problem: <a href="https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box">
 * minimum-number-of-operations-to-move-all-balls-to-each-box</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1769 {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        char[] chars = boxes.toCharArray();
        for (int i = 0; i < res.length; i++) {
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1') {
                    count += Math.abs(i - j);
                }
            }
            res[i] = count;
        }

        return res;
    }
}
