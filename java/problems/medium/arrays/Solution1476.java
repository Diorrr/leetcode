package problems.medium.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="link">
 * problem</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1476 {
    class SubrectangleQueries {
        int[][] rectangle;
        List<int[]> hist = new ArrayList<>();

        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            hist.add(new int[]{row1, col1, row2, col2, newValue});
        }

        public int getValue(int row, int col) {
            for (int i = hist.size() - 1; i >= 0; i--) {
                int[] elem = hist.get(i);
                if (elem[0] <= row && elem[1] <= col && elem[2] >= row && elem[3] >= col) {
                    return elem[4];
                }
            }
            return this.rectangle[row][col];
        }
    }

    class SubrectangleQueries1 {
        int[][] rectangle;

        public SubrectangleQueries1(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i < row2; i++) {
                for (int j = col1; j < col2; j++) {
                    this.rectangle[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return this.rectangle[row][col];
        }
    }
}
