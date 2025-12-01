package problems.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Time Complexity: O(NlogN) / O(N)
 * Space Complexity： O(1) / O(1)
 */
class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int sum;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int toAdd = target - numbers[i];
            if (pos.containsKey(toAdd)) {
                return new int[]{pos.get(toAdd), i + 1};
            }
            pos.put(numbers[i], i + 1);
        }
        return new int[]{};
    }

    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int secondAdd = target - numbers[i];
            int l = i, r = numbers.length;
            int m;
            while (l < r - 1) {
                m = (l + r) / 2;
                if (numbers[m] == secondAdd) {
                    r = m;
                    break;
                } else if (numbers[m] < secondAdd) {
                    l = m;
                } else {
                    r = m;
                }
            }
            if (r < numbers.length && numbers[r] == secondAdd) {
                return new int[]{i + 1, r + 1};
            }
        }
        return new int[]{};
    }
    // quick solution from discussions
}
