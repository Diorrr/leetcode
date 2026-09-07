package problems.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/distribute-elements-into-two-arrays-i">
 * distribute-elements-into-two-arrays-i</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3069 {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (list1.get(list1.size() - 1) > list2.get(list2.size() - 1)) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            nums[i] = list1.get(i);
        }
        for (int i = 0; i < list2.size(); i++) {
            nums[i + list1.size()] = list2.get(i);
        }
        return nums;
    }
}
