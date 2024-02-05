package problems.easy.string;


/**
 * Problem: <a href="https://leetcode.com/problems/first-unique-character-in-a-string">
 * first-unique-character-in-a-string</a>
 * Time Complexity: O(N)
 * Space Complexity： O(1)
 */
class Solution387 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] input = s.toCharArray();

        for (char c : input) {
            count[c - 'a']++;
        }
        for (int i = 0; i < input.length; i++) {
            if (count[input[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
