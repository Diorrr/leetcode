package problems.leetcode.medium.arrays;


/**
 * Problem: <a href="https://leetcode.com/problems/rotating-the-box">
 * rotating-the-box</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1861 {
    public char[][] rotateTheBox(char[][] box) {
        char[][] res = new char[box[0].length][box.length];
        for (int i = 0; i < box.length; i++) {
            int pos = box[i].length - 1;
            for (int j = box[i].length - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    res[pos][res[0].length - 1 - i] = '#';
                    pos--;
                } else if (box[i][j] == '*') {
                    res[j][res[0].length - 1 - i] = '*';
                    pos = j - 1;
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (res[i][j] == '\u0000') {
                    res[i][j] = '.';
                }
            }
        }
        return res;
    }

    public char[][] rotateTheBox2(char[][] box) {
        char[][] res = new char[box[0].length][box.length];
        for (int i = 0; i < box.length; i++) {
            int pos = box[i].length - 1;
            for (int j = box[i].length - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    res[pos][res[0].length - 1 - i] = '#';
                    pos--;
                } else if (box[i][j] == '*') {
                    while (pos > j) {
                        res[pos][res[0].length - 1 - i] = '.';
                        pos--;
                    }
                    res[pos][res[0].length - 1 - i] = '*';
                    pos--;
                }
            }
            while (pos >= 0) {
                res[pos][res[0].length - 1 - i] = '.';
                pos--;
            }
        }

        return res;
    }
}
