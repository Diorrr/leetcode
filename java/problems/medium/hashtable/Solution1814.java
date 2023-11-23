package problems.medium.hashtable;


import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/count-nice-pairs-in-an-array">
 * count-nice-pairs-in-an-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1814 {
    public int countNicePairs(int[] nums) {
        long res = 0;
        int mod = (int) 1e9 + 7;
        Map<Integer, Integer> countPairs = new HashMap<>();
        for (int num : nums) {
            int diff = num - rev(num);
            countPairs.put(diff, countPairs.getOrDefault(diff, 0) + 1);
        }
        for (Integer count : countPairs.values()) {
            res = (res + ((long) count * (count - 1)) / 2) % mod;
        }

        return (int) res;
    }

    private int rev(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

    private int diff(int num) {
        char[] rev = String.valueOf(num).toCharArray();
        for (int i = 0; i < rev.length / 2; i++) {
            char t = rev[i];
            rev[i] = rev[rev.length - 1 - i];
            rev[rev.length - 1 - i] = t;
        }

        return num - Integer.valueOf(new String(rev));
    }
}
