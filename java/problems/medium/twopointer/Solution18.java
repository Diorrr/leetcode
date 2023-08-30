package problems.medium.twopointer;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/4sum">
 * 4sum</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long sumCurr = nums[i] + nums[j];
                long sumLeft;
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    sumLeft = target - (sumCurr + nums[l] + nums[r]);
                    if (sumLeft == 0) {
                        set.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    } else if (sumLeft < 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }

        return set.stream().toList();
    }
}
