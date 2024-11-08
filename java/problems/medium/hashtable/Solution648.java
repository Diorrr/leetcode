package problems.medium.hashtable;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/replace-words">
 * replace-words</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder res = new StringBuilder();
        Set<String> set = new HashSet<>(dictionary);
        for (String word : sentence.split(" ")) {
            StringBuilder toAdd = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                toAdd.append(word.charAt(i));
                if (set.contains(toAdd.toString())) {
                    break;
                }
            }
            res.append(toAdd).append(" ");
        }

        return res.deleteCharAt(res.length() - 1).toString();
    }
}
