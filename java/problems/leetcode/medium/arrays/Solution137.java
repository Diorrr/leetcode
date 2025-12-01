package problems.leetcode.medium.arrays;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/single-number-ii">
 * single-number-ii</a>
 * Time Complexity: O(N)
 * Space Complexity：O(N)
 */
class Solution137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < count.length; i++) {
                if ((1 << i & num) != 0) {
                    count[i]++;
                }
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 3 == 1) {
                res += (1 << i);
            }
        }
        return res;
    }

    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Arrays.stream(nums).forEach(num -> {
            count.putIfAbsent(num, 0);
            count.put(num, count.get(num) + 1);
        });

        return count.entrySet().stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .findAny()
                    .orElse(0);
    }
}
