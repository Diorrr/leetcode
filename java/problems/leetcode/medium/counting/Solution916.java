package problems.leetcode.medium.counting;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/word-subsets">
 * word-subsets</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[] maxWordCount2 = new int[26];

        for (String word : words2) {
            int[] tmp = getCount(word);
            for (int i = 0; i < 26; i++) {
                maxWordCount2[i] = Math.max(tmp[i], maxWordCount2[i]);
            }
        }
        for (String word1 : words1) {
            int[] wordCount1 = getCount(word1);
            if (isSubset(wordCount1, maxWordCount2)) {
                res.add(word1);
            }
        }
        return res;
    }

    private boolean isSubset(int[] wordCount1, int[] maxWordCount2) {
        for (int i = 0; i < 26; i++) {
            if (wordCount1[i] < maxWordCount2[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getCount(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }
}
