package problems.easy.string;


/**
 * Problem: <a href="https://leetcode.com/problems/circular-sentence">
 * circular-sentence</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2490 {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        if (words[0].charAt(0) != words[words.length - 1].charAt(words[words.length - 1].length() - 1)) {
            return false;
        }
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                return false;
            }
        }
        return true;
    }
}
