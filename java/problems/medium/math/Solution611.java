package problems.medium.math;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/valid-triangle-number">
 * valid-triangle-number</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution611 {
    public int triangleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int[] count = new int[1001];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 2; i <= Arrays.stream(nums).max().getAsInt(); i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int min = Math.max(nums[i], nums[j]);
                int max = nums[i] + nums[j] - 1;
                res += Math.max(count[max] - count[min], 0);
            }
        }

        return res;
    }

    public int triangleNumber2(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (checkTraingle(nums[i], nums[j], nums[k])) {
                        res++;
                    } else {
                        break;
                    }
                }
            }
        }

        return res;
    }

    private boolean checkTraingle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }
}
