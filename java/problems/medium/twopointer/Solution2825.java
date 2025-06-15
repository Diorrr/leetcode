package problems.medium.twopointer;


/**
 * Problem: <a href="https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments">
 * make-string-a-subsequence-using-cyclic-increments</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2825 {
    public boolean canMakeSubsequence(String str1, String str2) {
        char[] word1 = str1.toCharArray();
        char[] word2 = str2.toCharArray();
        int index1 = 0;
        int index2 = 0;

        while (index1 < word1.length && index2 < word2.length) {
            if (word1[index1] == word2[index2] || (char) ('a' + (word1[index1] + 1 - 'a') % 26) == word2[index2]) {
                index2++;
            }
            index1++;
        }
        return index2 == word2.length;
    }
}
