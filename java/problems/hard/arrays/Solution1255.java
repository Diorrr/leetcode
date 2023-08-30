package problems.hard.arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: https://leetcode.com/problems/maximum-score-words-formed-by-letters/
 * Time Complexity:
 * Space Complexity：
 */
class Solution1255 {
    // solution from comments
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] countChars = new int[26];
        for (char letter : letters) {
            countChars[letter - 'a']++;
        }

        return backtrack(0, words, countChars, score);
    }

    private int backtrack(int index, String[] words, int[] countChars, int[] score) {
        if (index == words.length) {
            return 0;
        }

        int[] nextCount = countChars.clone();
        int currScore = 0;
        int wordSum = 0;
        for (int i = 0; i < words[index].length(); i++) {
            int wordChar = words[index].charAt(i) - 'a';
            if (nextCount[wordChar] == 0) {
                wordSum = -1;
                break;
            }
            nextCount[wordChar]--;
            wordSum += score[wordChar];
        }

        if (wordSum > 0) {
            currScore = wordSum + backtrack(index + 1, words, nextCount, score);
        }
        currScore = Math.max(currScore, backtrack(index + 1, words, countChars, score));

        return currScore;
    }

    public int maxScoreWords2(String[] words, char[] letters, int[] score) {
        int res = 0;
        int[] countChars = new int[26];
        for (char letter : letters) {
            countChars[letter - 'a']++;
        }

        for (int i = 1; i < Math.pow(2, words.length); i++) {
            StringBuilder subset = new StringBuilder();
            for (int j = 0; j < words.length; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.append(words[j]);
                }
            }
            int subsetSum = 0;
            List<Integer> distinctSubsetChars = subset.chars().distinct().boxed().collect(Collectors.toList());
            boolean isValidSubset = true;
            for (Integer subsetChar : distinctSubsetChars) {
                long count = subset.chars().filter(t -> t == subsetChar).count();
                if (count > countChars[subsetChar - 'a']) {
                    isValidSubset = false;
                    break;
                }
                subsetSum += score[subsetChar - 'a'] * count;
            }
            if (isValidSubset) {
                res = Math.max(res, subsetSum);
            }
        }

        return res;
    }
}
