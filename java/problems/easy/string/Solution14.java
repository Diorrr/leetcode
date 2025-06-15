package problems.easy.string;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/longest-common-prefix">
 * longest-common-prefix</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix1(String[] strs) {
        int minLength = Arrays.stream(strs).mapToInt(String::length).min().getAsInt();
        int resLenght = 0;
        for (int i = 0; i < minLength; i++) {
            int finalI = i;
            if (Arrays.stream(strs).map(t -> t.charAt(finalI)).distinct().count() == 1) {
                resLenght++;
            } else {
                break;
            }
        }
        return strs[0].substring(0, resLenght);
    }
}
