package problems.medium.hashtable;


import java.util.HashSet;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix">
 * find-the-length-of-the-longest-common-prefix</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3043 {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int res = 0;
        Set<String> prefixSet = new HashSet<>();
        for (int num : arr1) {
            StringBuilder sb = new StringBuilder();
            for (char c : String.valueOf(num).toCharArray()) {
                sb.append(c);
                prefixSet.add(sb.toString());
            }
        }
        for (int num : arr2) {
            StringBuilder sb = new StringBuilder();
            for (char c : String.valueOf(num).toCharArray()) {
                sb.append(c);
                if (prefixSet.contains(sb.toString())) {
                    res = Math.max(sb.length(), res);
                }
            }
        }
        return res;
    }

    public int longestCommonPrefix2(int[] arr1, int[] arr2) {
        int res = 0;
        Set<Integer> prefixSet = new HashSet<>();
        for (int num : arr1) {
            while (num != 0) {
                prefixSet.add(num);
                num /= 10;
            }
        }
        for (int num : arr2) {
            int len = (int) Math.log10(num) + 1;
            while (num != 0 && len > res) {
                if (prefixSet.contains(num)) {
                    res = len;
                }
                num /= 10;
                len--;
            }
        }
        return res;
    }
}
