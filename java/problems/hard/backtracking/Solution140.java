package problems.hard.backtracking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/word-break-ii">
 * word-break-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution140 {
    List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        findComb(s.toCharArray(), new HashSet<>(wordDict), 0, new StringBuilder(), new StringBuilder());
        return res;
    }

    private void findComb(char[] charArray, HashSet<String> words, int index, StringBuilder curr, StringBuilder sent) {
        if (index < charArray.length) {
            curr.append(charArray[index]);
            if (words.contains(curr.toString())) {
                StringBuilder sentNew = getNewSent(curr, sent);
                findComb(charArray, words, index + 1, new StringBuilder(), sentNew);
            }
            findComb(charArray, words, index + 1, curr, sent);
        } else if (index == charArray.length && words.contains(curr.toString())) {
                StringBuilder sentNew = getNewSent(curr, sent);
                res.add(sentNew.toString());
            }

    }

    private StringBuilder getNewSent(final StringBuilder curr, final StringBuilder sent) {
        return sent.isEmpty()
                ? new StringBuilder(curr)
                : new StringBuilder(sent).append(" ").append(curr);
    }
}
