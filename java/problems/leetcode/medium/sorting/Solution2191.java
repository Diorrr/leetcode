package problems.leetcode.medium.sorting;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/sort-the-jumbled-numbers">
 * sort-the-jumbled-numbers</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2191 {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] res = new int[nums.length];
        int[][] sort = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int map = num == 0 ? mapping[0] : 0;
            int dec = 1;
            while (num != 0) {
                map += dec * mapping[num % 10];
                dec *= 10;
                num /= 10;
            }
            sort[i] = new int[]{map, i};
        }
        Arrays.sort(sort, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[sort[i][1]];
        }
        return res;
    }

    public int[] sortJumbled2(int[] mapping, int[] nums) {
        Map<Integer, Integer> mappedValue = new HashMap<>();
        for (int num : nums) {
            if (!mappedValue.containsKey(num)) {
                char[] numAsChar = String.valueOf(num).toCharArray();
                StringBuilder mappedNum = new StringBuilder();
                for (char c : numAsChar) {
                    mappedNum.append(mapping[c - '0']);
                }
                mappedValue.put(num, Integer.valueOf(mappedNum.toString()));
            }
        }
        return Arrays.stream(nums)
                     .boxed()
                     .sorted(Comparator.comparingInt(mappedValue::get))
                     .mapToInt(i -> i)
                     .toArray();
    }
}
