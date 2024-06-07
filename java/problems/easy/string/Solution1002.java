package problems.easy.string;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/find-common-characters">
 * find-common-characters</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1002 {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[][] count = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            for (char c : chars) {
                count[i][c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            int occNum = Integer.MAX_VALUE;
            for (int j = 0; j < words.length; j++) {
                occNum = Math.min(occNum, count[j][i]);
            }
            while (occNum-- > 0) {
                result.add(String.valueOf((char) ('a' + i)));
            }
        }
        return result;
    }
}
