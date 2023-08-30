package problems.medium.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: https://leetcode.com/problems/course-schedule-ii/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[0]]++;
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                res.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int i = 0; i < graph.get(from).size(); i++) {
                int to = graph.get(from).get(i);
                degree[to]--;
                if (degree[to] == 0) {
                    queue.add(to);
                    res.add(to);
                }
            }
        }

        return res.size() == numCourses ? res.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }
}
