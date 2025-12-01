package problems.leetcode.easy.string;


/**
 * Problem: <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string">
 * find-the-index-of-the-first-occurrence-in-a-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution28 {
    public int strStr2(String haystack, String needle) {
        for (int i = 0; i <= haystack.toCharArray().length - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean isFound = true;
                for (int j = 0; j < needle.toCharArray().length; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        isFound = false;
                        break;
                    }
                }
                if (isFound) {
                    return i;
                }
            }
        }

        return -1;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
