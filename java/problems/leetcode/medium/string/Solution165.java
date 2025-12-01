package problems.leetcode.medium.string;


/**
 * Problem: <a href="https://leetcode.com/problems/compare-version-numbers">
 * compare-version-numbers</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int length = Math.max(v1.length, v2.length);
        for (int i = 0; i < length; i++) {
            int rev1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int rev2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (rev1 != rev2) {
                return Integer.compare(rev1, rev2);
            }
        }
        return 0;
    }
}
