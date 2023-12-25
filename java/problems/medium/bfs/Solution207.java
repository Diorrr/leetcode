package problems.medium.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/course-schedule">
 * course-schedule</a>
 * Time Complexity: O(V + E)
 * Space Complexity： O(V)
 */
class Solution207 {
    ArrayList<Integer>[] graph;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        boolean[] used = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (isCycle(i, used, recStack)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCycle(int node, boolean[] used, boolean[] recStack) {
        if (recStack[node]) {
            return true;
        }
        if (used[node]) {
            return false;
        }
        used[node] = true;
        recStack[node] = true;
        for (Integer to : graph[node]) {
            if (isCycle(to, used, recStack)) {
                return true;
            }
        }
        recStack[node] = false;

        return false;
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int[] prerequisite : prerequisites) {
            if (graph[prerequisite[1]] == null) {
                graph[prerequisite[1]] = new ArrayList<>();
            }
            degree[prerequisite[0]]++;
            graph[prerequisite[1]].add(prerequisite[0]);
        }

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                numCourses--;
            }
        }

        while (!queue.isEmpty()) {
            int from = queue.poll();
            if (graph[from] != null) {
                for (Integer to : graph[from]) {
                    degree[to]--;
                    if (degree[to] == 0) {
                        numCourses--;
                        queue.add(to);
                    }
                }
            }
        }

        return numCourses == 0;
    }
}
