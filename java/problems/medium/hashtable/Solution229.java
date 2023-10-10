package problems.medium.hashtable;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/majority-element-ii">
 * majority-element-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        int limit = nums.length / 3;
        List<Integer> res = new ArrayList<>();
        Arrays.stream(nums).forEach(num -> {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
            if (counter.get(num) == limit + 1) {
                res.add(num);
            }
        });

        return res;
    }
}
