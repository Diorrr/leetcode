package problems.leetcode.easy.string;


/**
 * Problem: <a href="https://leetcode.com/problems/reverse-prefix-of-word">
 * reverse-prefix-of-word</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2000 {
    public String reversePrefix(String word, char ch) {
        char[] res = new char[word.length()];
        char[] wordChars = word.toCharArray();
        int pos = word.indexOf(ch);
        for (int i = 0; i <= pos; i++) {
            res[i] = wordChars[pos - i];
        }
        for (int i = pos + 1; i < wordChars.length; i++) {
            res[i] = wordChars[i];
        }

        return String.valueOf(res);
    }

    public String reversePrefix1(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(c);
            if (c == ch) {
                sb = sb.reverse();
                ch = 0;
            }
        }
        return sb.toString();
    }

    public String reversePrefix2(String word, char ch) {
        int firstOcc = word.indexOf(ch) + 1;
        return new StringBuilder(word.substring(0, firstOcc)).reverse() + word.substring(firstOcc);
    }
}
