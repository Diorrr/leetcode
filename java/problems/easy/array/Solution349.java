package problems.easy.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/intersection-of-two-arrays">
 * intersection-of-two-arrays</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] exist = new boolean[1001];
        List<Integer> res = new ArrayList<>();
        for (int num : nums1) {
            exist[num] = true;
        }
        for (int num : nums2) {
            if (exist[num]) {
                res.add(num);
            }
        }

        return res.stream().distinct().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        boolean[] exist = new boolean[1001];
        Arrays.stream(nums1)
              .distinct()
              .forEach(num -> exist[num] = true);

        return Arrays.stream(nums2)
                     .distinct()
                     .filter(num -> exist[num])
                     .toArray();
    }
}
