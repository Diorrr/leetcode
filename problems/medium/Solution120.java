package problems.medium;

import java.util.List;

/**
 * Problem: https://leetcode.com/problems/triangle/
 * Time Complexity: O(n*m)
 * Space Complexity：
 */
class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        } else if (triangle.size() == 2) {
            return triangle.get(0).get(0) + triangle.get(1).stream().min(Integer::compareTo).get();
        }
        triangle.get(1).set(0, triangle.get(0).get(0) + triangle.get(1).get(0));
        triangle.get(1).set(1, triangle.get(0).get(0) + triangle.get(1).get(1));
        for (int i = 2; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(0) + triangle.get(i).get(j));
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(triangle.get(i - 1).size() - 1) + triangle.get(i).get(j));
                } else {
                    Integer minPath = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                    triangle.get(i).set(j, minPath + triangle.get(i).get(j));
                }
            }
        }

        return triangle.get(triangle.size() - 1).stream().min(Integer::compareTo).get();
    }
}
