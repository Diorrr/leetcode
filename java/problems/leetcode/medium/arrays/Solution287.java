package problems.leetcode.medium.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/find-the-duplicate-number">
 * find-the-duplicate-number</a>
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public int findDuplicate3(int[] nums) {
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                return idx;
            }
            nums[idx] = -nums[idx];
        }

        return 0;
    }

    public int findDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return 0;
    }

    public int findDuplicate2(int[] nums) {
        int[] used = new int[nums.length + 2];
        for (int num : nums) {
            if (used[num] > 0) {
                return num;
            }
            used[num]++;
        }

        return 0;
    }
}
