package problems.leetcode.easy.array;

/**
 * Problem: <a href="https://leetcode.com/problems/delete-columns-to-make-sorted">
 * delete-columns-to-make-sorted</a>
 * Time Complexity: O(n*m)
 * Space Complexity：
 */
class Solution944 {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j-1].charAt(i) > strs[j].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public int minDeletionSize2(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        char[][] arr = new char[rows][];

        for (int r = 0; r < rows; r++) {
            arr[r] = strs[r].toCharArray();
        }

        int count = 0;
        for (int c = 0; c < cols; c++) {
            for (int r = 1; r < rows; r++) {
                if (arr[r - 1][c] > arr[r][c]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
