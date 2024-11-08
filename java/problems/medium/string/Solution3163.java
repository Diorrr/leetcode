package problems.medium.string;


/**
 * Problem: <a href="https://leetcode.com/problems/string-compression-iii">
 * string-compression-iii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3163 {
    public String compressedString(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        char[] chars = word.toCharArray();
        for (int i = 1; i < word.length(); i++) {
            if (chars[i - 1] == chars[i] && count < 9) {
                count++;
            } else {
                stringBuilder.append(count).append(chars[i - 1]);
                count = 1;
            }
        }
        stringBuilder.append(count).append(chars[word.length() - 1]);
        return stringBuilder.toString();
    }
}
