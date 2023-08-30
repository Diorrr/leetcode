package problems.medium.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: https://leetcode.com/problems/course-schedule/
 * Time Complexity:
 * Space Complexity：
 */
class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int counter = 0;
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[1]]++;
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                counter++;
            }
        }

        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int i = 0; i < graph.get(from).size(); i++) {
                int to = graph.get(from).get(i);
                degree[to]--;
                if (degree[to] == 0) {
                    counter++;
                    queue.add(to);
                }
            }
        }

        return counter == numCourses;
    }
}
