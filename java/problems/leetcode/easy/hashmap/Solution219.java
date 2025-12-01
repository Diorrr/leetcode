package problems.leetcode.easy.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/contains-duplicate-ii">
 * contains-duplicate-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indMap.containsKey(nums[i]) && i - indMap.get(nums[i]) <= k) {
                return true;
            }
            indMap.put(nums[i], i);
        }
        return false;
    }
}
