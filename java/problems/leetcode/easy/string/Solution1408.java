package problems.leetcode.easy.string;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/string-matching-in-an-array">
 * string-matching-in-an-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1408 {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            for (String s : words) {
                if (!s.equals(word) && s.contains(word)) {
                    res.add(word);
                    break;
                }
            }
        }
        return res;
    }
}
