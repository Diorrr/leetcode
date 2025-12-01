package problems.leetcode.medium.window;

/**
 * Problem: https://leetcode.com/problems/fruit-into-baskets/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution904 {
    public int totalFruit(int[] fruits) {
        if (fruits.length < 3) {
            return fruits.length;
        }
        int res = 0, l = 0, used1 = -1, used2 = -1;
        int index = 0;
        while (index < fruits.length) {
            if (used1 == -1) {
                used1 = fruits[index];
                l = index;
                index++;
            } else if (used2 == -1 && used1 != fruits[index]) {
                used2 = fruits[index];
                res = Math.max(res, index - l + 1);
                index++;
            } else if (used1 == fruits[index] || used2 == fruits[index]) {
                res = Math.max(res, index - l + 1);
                index++;
            } else {
                if (used2 != fruits[index - 1]) {
                    int t = used2;
                    used2 = used1;
                    used1 = t;
                }
                for (int i = index; i >= 0; i--) {
                    if (fruits[i] == used1) {
                        l = i + 1;
                        used1 = used2;
                        used2 = -1;
                        break;
                    }
                }
            }
        }

        return res;
    }
}
