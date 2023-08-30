package problems.medium.arrays;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/single-number-ii">
 * single-number-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution137 {
    public int singleNumber(int[] nums) {
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
