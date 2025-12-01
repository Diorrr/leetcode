package problems.leetcode.medium.window;


/**
 * Problem: <a href="https://leetcode.com/problems/grumpy-bookstore-owner">
 * grumpy-bookstore-owner</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res = 0;
        int totalWithGrumpiness = 0;
        int withGrumpiness = 0;
        int withoutGrumpiness = 0;
        for (int i = 0; i < minutes; i++) {
            withGrumpiness += customers[i] * (1 - grumpy[i]);
            withoutGrumpiness += customers[i];
        }
        for (int i = 0; i < customers.length; i++) {
            totalWithGrumpiness += customers[i] * (1 - grumpy[i]);
        }
        res = Math.max(totalWithGrumpiness - withGrumpiness + withoutGrumpiness, res);
        for (int i = minutes; i < customers.length; i++) {
            withGrumpiness += customers[i] * (1 - grumpy[i]) - customers[i - minutes] * (1 - grumpy[i - minutes]);
            withoutGrumpiness += customers[i] - customers[i - minutes];
            res = Math.max(totalWithGrumpiness - withGrumpiness + withoutGrumpiness, res);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution1052().maxSatisfied(
                        new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                        new int[]{0, 1, 0, 1, 0, 1, 0, 1},
                        3
                )
        );
    }
}
