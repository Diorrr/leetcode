package problems.medium.bit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution421 {
    public int findMaximumXOR(int[] nums) {
        int maxLength = Integer.toBinaryString(Arrays.stream(nums).max().getAsInt()).length();
        int res = 0, currXor;
        for (int i = maxLength-1; i >=0 ; i--) {
            Set<Integer> prefix = new HashSet<>();
            res<<=1;
            currXor = res | 1;

            for (int num : nums) {
                prefix.add(num>>i);
            }

            for (Integer pref : prefix) {
                if (prefix.contains(pref^currXor)){
                    res = currXor;
                    break;
                }
            }
        }

        return res;
    }
}
