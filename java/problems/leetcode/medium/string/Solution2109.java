package problems.leetcode.medium.string;


/**
 * Problem: <a href="https://leetcode.com/problems/adding-spaces-to-a-string">
 * adding-spaces-to-a-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2109 {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder();
        int pos = 0;
        for (int spacePos : spaces) {
            res.append(s, pos, spacePos);
            res.append(" ");
            pos = spacePos;
        }
        res.append(s.substring(pos));
        return res.toString();
    }
}
