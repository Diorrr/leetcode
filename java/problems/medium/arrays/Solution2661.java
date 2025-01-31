package problems.medium.arrays;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/first-completely-painted-row-or-column">
 * first-completely-painted-row-or-column</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] posRow = new int[arr.length + 1];
        int[] posColumn = new int[arr.length + 1];
        int[] countRow = new int[mat.length];
        int[] countColumn = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                countRow[i] += mat[i][j];
                countColumn[j] += mat[i][j];
                posRow[mat[i][j]] = i;
                posColumn[mat[i][j]] = j;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            countRow[posRow[arr[i]]] -= arr[i];
            countColumn[posColumn[arr[i]]] -= arr[i];
            if (countRow[posRow[arr[i]]] == 0 || countColumn[posColumn[arr[i]]] == 0) {
                return i;
            }
        }
        return 0;
    }

    public int firstCompleteIndex1(int[] arr, int[][] mat) {
        Map<Integer, int[]> posMap = new HashMap<>();
        int[] countRow = new int[mat.length];
        int[] countColumn = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                countRow[i] += mat[i][j];
                countColumn[j] += mat[i][j];
                posMap.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] pos = posMap.get(arr[i]);
            countRow[pos[0]] -= arr[i];
            countColumn[pos[1]] -= arr[i];
            if (countRow[pos[0]] == 0 || countColumn[pos[1]] == 0) {
                return i;
            }
        }
        return 0;
    }

    public int firstCompleteIndex2(int[] arr, int[][] mat) {
        Map<Integer, List<int[]>> pos = new HashMap<>();
        int[] countRow = new int[mat.length];
        int[] countColumn = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                pos.putIfAbsent(mat[i][j], new ArrayList<>());
                pos.get(mat[i][j]).add(new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (isCompleted(pos.getOrDefault(arr[i], List.of()), countRow, countColumn)) {
                return i;
            }
        }
        return 0;
    }

    private boolean isCompleted(List<int[]> posList, int[] countRow, int[] countColumn) {
        for (int[] pos : posList) {
            countRow[pos[0]]++;
            countColumn[pos[1]]++;
            if (countRow[pos[0]] == countColumn.length || countColumn[pos[1]] == countRow.length) {
                return true;
            }
        }
        return false;
    }
}
