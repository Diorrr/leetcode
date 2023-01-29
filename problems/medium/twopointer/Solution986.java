package problems.medium.twopointer;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/interval-list-intersections/
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length + secondList.length == 1) {
            return new int[][]{};
        }

        List<int[]> res = new ArrayList<>();
        int pointerOne = 0, pointerTwo = 0;
        while (pointerOne < firstList.length && pointerTwo < secondList.length) {
            int[] first = firstList[pointerOne], second = secondList[pointerTwo];
            // no intersection
            if (first[1] < second[0]) {
                pointerOne++;
            } else if (first[0] > second[1]) {
                pointerTwo++;
            }// intersect
            else if (first[0] <= second[0] && first[1] <= second[1]) {
                res.add(new int[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])});
                pointerOne++;
            } else if (first[0] >= second[0] && first[1] <= second[1]) {
                res.add(new int[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])});
                pointerOne++;
            } else if (first[0] >= second[0] && first[1] >= second[1]) {
                res.add(new int[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])});
                pointerTwo++;
            } else if (first[0] <= second[0] && first[1] >= second[1]) {
                res.add(new int[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])});
                pointerTwo++;
            }

        }

        return res.toArray(new int[res.size()][]);
    }
}
