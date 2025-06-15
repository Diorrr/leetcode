package problems.easy.string;


/**
 * Problem: <a href="https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence">
 * check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
