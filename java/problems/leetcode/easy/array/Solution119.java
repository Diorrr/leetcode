package problems.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/pascals-triangle-ii">
 * pascals-triangle-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        long value = 1;
        for (int i = 0; i < rowIndex + 1; i++) {
            res.add((int) value);
            value = value * (rowIndex - i) / (i + 1);
        }

        return res;
    }

    public List<Integer> getRow1(int rowIndex) {
        int[] res = new int[rowIndex + 1];
        res[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = i; j >= 1; j--) {
                res[j] += res[j - 1];
            }
        }

        return Arrays.stream(res).boxed().toList();
    }

    public List<Integer> getRow2(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        } else if (rowIndex == 1) {
            return List.of(1, 1);
        }
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(1);
        rowIndex--;

        while (rowIndex > 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int i = 0; i < res.size() - 1; i++) {
                temp.add(res.get(i) + res.get(i + 1));
            }
            temp.add(1);
            rowIndex--;
            res = new ArrayList<>(temp);
        }

        return res;
    }
}
