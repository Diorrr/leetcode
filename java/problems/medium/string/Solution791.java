package problems.medium.string;


/**
 * Problem: <a href="https://leetcode.com/problems/custom-sort-string">
 * custom-sort-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution791 {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : order.toCharArray()) {
            while (count[c - 'a'] > 0) {
                sb.append(c);
                count[c - 'a']--;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                sb.append((char) (i + 'a'));
                count[i]--;
            }
        }

        return sb.toString();
    }
}
