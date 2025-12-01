package problems.leetcode.hard.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/text-justification">
 * text-justification</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int currLength = 0;
        int currIndex = 0;
        int numberOfWords = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (currLength + numberOfWords + word.length() > maxWidth) {
                res.add(getLineToAdd(words, maxWidth, currLength, numberOfWords, currIndex, i));
                currIndex = i;
                currLength = word.length();
                numberOfWords = 1;
            } else {
                currLength += word.length();
                numberOfWords++;
            }
        }
        int spaces = maxWidth - currLength;
        StringBuilder line = new StringBuilder();
        for (int j = currIndex; j < words.length; j++) {
            line.append(words[j]);
            if (spaces > 0) {
                line.append(" ");
                spaces--;
            }
        }
        if (spaces > 0) {
            line.append(" ".repeat(spaces));
        }
        res.add(line.toString());
        return res;
    }

    private String getLineToAdd(String[] words, int maxWidth, int currLength, int numberOfWords, int currIndex, int i) {
        int spaces = maxWidth - currLength;
        if (numberOfWords == 1) {
            return words[currIndex] + " ".repeat(spaces);
        }
        int spaceBetweenWords = spaces / (numberOfWords - 1);
        int extraSpaces = spaces % (numberOfWords - 1);
        StringBuilder line = new StringBuilder();
        for (int j = currIndex; j < i; j++) {
            line.append(words[j]);
            if (j < i - 1) {
                line.append(" ".repeat(spaceBetweenWords));
                if (extraSpaces > 0) {
                    line.append(" ");
                    extraSpaces--;
                }
            }
        }
        return line.toString();
    }
}
