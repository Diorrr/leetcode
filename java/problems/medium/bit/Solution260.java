package problems.medium.bit;


import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/single-number-iii">
 * single-number-iii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution260 {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        xor &= -xor;
        for (int num : nums) {
            if ((num & xor) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public int[] singleNumber2(int[] nums) {
        int[] res = new int[2];
        int index = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (count.get(num) == 1) {
                res[index++] = num;
            }
        }
        return res;
    }
}
