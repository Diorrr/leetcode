package problems.medium.math;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/largest-divisible-subset">
 * largest-divisible-subset</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            List<Integer> largerSet = new ArrayList<>();
            map.putIfAbsent(i, new ArrayList<>());
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0 && map.get(j).size() > largerSet.size()) {
                    largerSet = map.get(j);
                }
            }
            map.get(i).add(nums[i]);
            map.get(i).addAll(largerSet);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.get(i).size() > res.size()) {
                res = map.get(i);
            }
        }

        return res;
    }
}
