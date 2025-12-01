package problems.leetcode.easy.sim;

/**
 * Problem: <a href="https://leetcode.com/problems/fruits-into-baskets-ii">
 * fruits-into-baskets-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3477 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int res = fruits.length;
        for (int fruit : fruits) {
            for (int i = 0; i < baskets.length; i++) {
                if (baskets[i] >= fruit) {
                    baskets[i] = 0;
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}
