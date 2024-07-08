package problems.easy.array;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii">
 * intersection-of-two-arrays-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int[] count = new int[1001];
        for (int num : nums1) {
            count[num]++;
        }
        for (int num : nums2) {
            if (count[num] > 0) {
                count[num]--;
                list.add(num);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
