package problems.easy.greedy;

/**
 * Problem: <a href="https://leetcode.com/problems/can-place-flowers/">
 * can-place-flowers</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && n == 1) {
            return flowerbed[0] == 0;
        }
        if (1 < flowerbed.length && flowerbed[0] == 0 && flowerbed[1] == 0) {
            n--;
            flowerbed[0] = 1;
        }
        if (1 < flowerbed.length && flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
            n--;
            flowerbed[flowerbed.length - 1] = 1;
        }

        for (int i = 1; i < flowerbed.length - 1 && n > 0; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
            }
        }

        return n <= 0;
    }
}
