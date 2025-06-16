package problems.medium.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/course-schedule-ii">
 * course-schedule-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int index = 0;
        int[] res = new int[numCourses];
        int[] degree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>(numCourses);
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
                res[index++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (Integer to : graph.get(from)) {
                degree[to]--;
                if (degree[to] == 0) {
                    queue.add(to);
                    res[index++] = to;
                }
            }
        }

        return index == numCourses ? res : new int[0];
    }
}
