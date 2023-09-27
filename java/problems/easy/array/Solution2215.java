package problems.easy.array;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/find-the-difference-of-two-arrays">
 * find-the-difference-of-two-arrays</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>(Arrays.stream(nums1).boxed().toList());
        Set<Integer> set2 = new HashSet<>(Arrays.stream(nums2).boxed().toList());
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        for (int i : nums2) {
            if (!set1.contains(i)) {
                res1.add(i);
                set1.add(i);
            }
        }

        for (int i : nums1) {
            if (!set2.contains(i)) {
                res2.add(i);
                set2.add(i);
            }
        }
        res.add(res2);
        res.add(res1);

        return res;
    }
}
