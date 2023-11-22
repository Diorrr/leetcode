package problems.medium.priorityqueue;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/diagonal-traverse-ii">
 * diagonal-traverse-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] + a[2] == b[1] + b[2]
                ? Integer.compare(b[1], a[1]) : Integer.compare(a[1] + a[2], b[1] + b[2]));
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                queue.add(new int[]{nums.get(i).get(j), i, j});
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll()[0]);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
