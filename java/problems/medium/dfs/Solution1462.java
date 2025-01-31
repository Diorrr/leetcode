package problems.medium.dfs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/course-schedule-iv">
 * course-schedule-iv</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        boolean[][] isReachable = new boolean[numCourses][numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            isReachable[i][i] = true;
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (Integer to : graph.getOrDefault(curr, List.of())) {
                    if (!isReachable[i][to]) {
                        isReachable[i][to] = true;
                        queue.add(to);
                    }
                }
            }
        }

        for (int[] query : queries) {
            res.add(isReachable[query[0]][query[1]]);
        }

        return res;
    }

    public List<Boolean> checkIfPrerequisite2(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            graph.putIfAbsent(prerequisite[0], new ArrayList<>());
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int[] query : queries) {
            res.add(isReachable(graph, new boolean[numCourses], query[0], query[1]));
        }

        return res;
    }

    private boolean isReachable(Map<Integer, List<Integer>> graph, boolean[] used, int curr, int destination) {
        if (curr == destination) {
            return true;
        }
        used[curr] = true;
        for (Integer to : graph.getOrDefault(curr, List.of())) {
            if (!used[to] && isReachable(graph, used, to, destination)) {
                return true;
            }
        }

        return false;
    }
}
