package problems.leetcode.easy.string;

/**
 * Problem: <a href="https://leetcode.com/problems/add-binary">
 * add-binary</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int toAdd = 0;
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            if (a.length() - 1 - i >= 0) {
                toAdd += a.charAt(a.length() - 1 - i) - '0';
            }
            if (b.length() - 1 - i >= 0) {
                toAdd += b.charAt(b.length() - 1 - i) - '0';
            }
            res.append(toAdd % 2);
            toAdd /= 2;
        }
        if (toAdd == 1) {
            res.append(toAdd);
        }
        return res.reverse().toString();
    }
}
