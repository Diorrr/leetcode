package problems.leetcode.easy.queue;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix">
 * the-k-weakest-rows-in-a-matrix</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) > o2.get(i)) {
                        return 1;
                    }
                    if (o1.get(i) < o2.get(i)) {
                        return -1;
                    }
                }
                return 0;
            }
        });
        for (int i = 0; i < mat.length; i++) {
            List<Integer> rowAndIndex = new ArrayList<>();
            rowAndIndex.addAll(Arrays.stream(mat[i]).boxed().toList());
            rowAndIndex.add(i);
            queue.add(rowAndIndex);
        }

        for (int i = 0; i < k; i++) {
            List list = queue.poll();
            res[i] = (int) list.get(list.size() - 1);
        }

        return res;
    }

    public int[] kWeakestRows2(int[][] mat, int k) {
        int[] res = new int[k];
        int[] rowsIndex = new int[k];
        for (int i = 0; i < mat.length; i++) {
            rowsIndex[i] = i;
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = i + 1; j < mat.length; j++) {
                if (compareRows(mat[i], mat[j], rowsIndex[i], rowsIndex[j])) {
                    int[] temp = mat[i];
                    mat[i] = mat[j];
                    mat[j] = temp;
                    int tempIndex = rowsIndex[i];
                    rowsIndex[i] = rowsIndex[j];
                    rowsIndex[j] = tempIndex;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = rowsIndex[i];
        }

        return res;
    }

    private boolean compareRows(int[] row1, int[] row2, int rowsIndex1, int rowsIndex2) {
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] > row2[i]) {
                return true;
            }
            if (row1[i] < row2[i]) {
                return false;
            }
        }
        return rowsIndex1 > rowsIndex2;
    }
}
