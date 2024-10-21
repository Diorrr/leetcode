package problems.easy.linkedlist;


import java.util.LinkedList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-string-length-after-removing-substrings">
 * minimum-string-length-after-removing-substrings</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2696 {
    public int minLength(String s) {
        List<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == 'B' && !list.isEmpty() && list.get(list.size() - 1) == 'A') {
                list.remove(list.size() - 1);
            } else if (c == 'D' && !list.isEmpty() && list.get(list.size() - 1) == 'C') {
                list.remove(list.size() - 1);
            } else {
                list.add(c);
            }
        }
        return list.size();
    }
}
