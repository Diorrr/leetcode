package problems.leetcode.easy.hashmap;


import java.util.HashMap;

/**
 * Problem: <a href="https://leetcode.com/problems/kth-distinct-string-in-an-array">
 * kth-distinct-string-in-an-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2053 {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : arr) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
        for (String s : arr) {
            if (count.get(s) == 1) {
                k--;
            }
            if (k == 0) {
                return s;
            }
        }
        return "";
    }
}
