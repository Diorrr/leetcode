package problems.medium.hashtable;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Problem: <a href="https://leetcode.com/problems/longest-square-streak-in-an-array">
 * longest-square-streak-in-an-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2501 {
    public int longestSquareStreak(int[] nums) {
        int res = 1;
        HashMap<Long, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put((long) num, true);
        }
        for (int num : nums) {
            long curr = num;
            int count = 1;
            while (map.containsKey(curr * curr)) {
                curr = curr * curr;
                count++;
            }
            res = Math.max(count, res);
        }
        return res == 1 ? -1 : res;
    }

    public int longestSquareStreak2(int[] nums) {
        int res = 1;
        Set<Long> set = Arrays.stream(nums).mapToLong(Long::valueOf).boxed().collect(Collectors.toSet());
        for (int num : nums) {
            long curr = num;
            int count = 1;
            while (set.contains(curr * curr)) {
                curr = curr * curr;
                count++;
            }
            res = Math.max(count, res);
        }
        return res == 1 ? -1 : res;
    }
}
