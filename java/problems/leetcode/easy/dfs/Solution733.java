package problems.leetcode.easy.dfs;

/**
 * Problem: https://leetcode.com/problems/flood-fill/
 * Time Complexity:
 * Space Complexity：
 */
class Solution733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            paint(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    private void paint(int[][] image, int x, int y, int oldColor, int newColor) {
        if (image[x][y] == oldColor) {
            image[x][y] = newColor;
            if (y > 0 && image[x][y - 1] == oldColor) {
                paint(image, x, y - 1, oldColor, newColor);
            }
            if (y + 1 < image[x].length && image[x][y + 1] == oldColor) {
                paint(image, x, y + 1, oldColor, newColor);
            }
            if (x > 0 && image[x - 1][y] == oldColor) {
                paint(image, x - 1, y, oldColor, newColor);
            }
            if (x + 1 < image.length && image[x + 1][y] == oldColor) {
                paint(image, x + 1, y, oldColor, newColor);
            }
        }
    }
}
