package problems.leetcode.easy.sorting;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-product-of-three-numbers">
 * maximum-product-of-three-numbers</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution628 {
    public int maximumProduct(int[] nums) {
        int[] count = new int[2001];
        Integer max = null;
        for (int num : nums) {
            count[1000 + num]++;
        }
        Integer posMax1 = null;
        Integer posMax2 = null;
        for (int num = 1000; num >= -1000; num--) {
            int availCount = count[num + 1000];
            while (availCount > 0) {
                if (max == null) {
                    max = num;
                } else if (posMax1 == null) {
                    posMax1 = num;
                } else if (posMax2 == null) {
                    posMax2 = num;
                    break;
                }
                availCount--;
            }
        }
        Integer negMax1 = null;
        Integer negMax2 = null;
        for (int num = -1000; num < 1001; num++) {
            int availCount = count[num + 1000];
            while (availCount > 0) {
                if (negMax1 == null) {
                    negMax1 = num;
                } else if (negMax2 == null) {
                    negMax2 = num;
                    break;
                }
                availCount--;
            }
        }
        return Math.max(negMax1 * negMax2 * max, posMax1 * posMax2 * max);
    }

    public int maximumProduct2(int[] nums) {
        int max = -1001;
        int posMax1 = -1001;
        int posMax2 = -1001;
        int negMax1 = 1001;
        int negMax2 = 1001;
        for (int num : nums) {
            int pMax = max;
            int prevA = posMax1;
            int prevX = negMax1;

            max = Math.max(max, num);
            posMax1 = Math.max(posMax1, Math.min(pMax, num));
            posMax2 = Math.max(posMax2, Math.min(prevA, num));
            negMax1 = Math.min(negMax1, num);
            negMax2 = Math.min(negMax2, Math.max(prevX, num));
        }
        return Math.max(max * posMax1 * posMax2, max * negMax1 * negMax2);
    }

    public int maximumProduct1(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                        nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
    }
}
