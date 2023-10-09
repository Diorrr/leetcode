package problems.medium.string;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color">
 * remove-colored-pieces-if-both-neighbors-are-the-same-color</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2038 {
    public boolean winnerOfGame(String colors) {
        int aOcc = 0;
        int bOcc = 0;
        char[] colorsChar = colors.toCharArray();
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colorsChar[i - 1] == 'A' && colorsChar[i] == 'A' && colorsChar[i + 1] == 'A') {
                aOcc++;
            }
            if (colorsChar[i - 1] == 'B' && colorsChar[i] == 'B' && colorsChar[i + 1] == 'B') {
                bOcc++;
            }
        }

        return aOcc > bOcc;
    }

    public boolean winnerOfGame2(String colors) {
        int aOcc = 0;
        int bOcc = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i - 1) == 'A' && colors.charAt(i) == 'A' && colors.charAt(i + 1) == 'A') {
                aOcc++;
            }
            if (colors.charAt(i - 1) == 'B' && colors.charAt(i) == 'B' && colors.charAt(i + 1) == 'B') {
                bOcc++;
            }
        }

        return aOcc > bOcc;
    }
}
