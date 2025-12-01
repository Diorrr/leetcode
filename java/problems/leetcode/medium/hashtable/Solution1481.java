package problems.leetcode.medium.hashtable;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals">
 * least-number-of-unique-integers-after-k-removals</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr.length - k <= 1) {
            return arr.length - k;
        }
        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] countToNum = new List[arr.length + 1];
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        count.forEach((key, value) -> {
            if (countToNum[value] == null) {
                countToNum[value] = new ArrayList<>();
            }
            countToNum[value].add(key);
        });
        for (int i = 1; i < countToNum.length; i++) {
            if (countToNum[i] != null) {
                if (countToNum[i].size() * i <= k) {
                    k -= countToNum[i].size() * i;
                } else {
                    res += countToNum[i].size() - k / i;
                    k %= i;
                }
            }
        }
        return res;
    }
}
