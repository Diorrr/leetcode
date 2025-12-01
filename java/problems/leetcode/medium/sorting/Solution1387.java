package problems.leetcode.medium.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/sort-integers-by-the-power-value/
 * Time Complexity:
 * Space Complexity：
 */
class Solution1387 {
    public int getKth(int lo, int hi, int k) {
        int[] steps = new int[1001];
        List<int[]> res = new ArrayList<>();
        steps[0] = 0;
        steps[1] = 0;
        steps[2] = 1;
        steps[3] = 7;
        for (int i = lo; i <= hi; i++) {
            int step = calculateStep(i, steps);
            steps[i] = step;
            res.add(new int[]{i, step});
        }

        res.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        return res.get(k - 1)[0];
    }

    private int calculateStep(int number, int[] steps) {
        int numberOfSteps = 0;
        while (number != 1) {
            if (number < 1001 && steps[number] != 0) {
                return numberOfSteps + steps[number];
            }
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = number * 3 + 1;
            }
            numberOfSteps++;
        }

        return numberOfSteps;
    }
}
