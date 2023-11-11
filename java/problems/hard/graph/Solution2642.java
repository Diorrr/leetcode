package problems.hard.graph;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/design-graph-with-shortest-path-calculator">
 * design-graph-with-shortest-path-calculator</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2642 {
    public static class Graph {
        int n;
        int[][] edges;

        public Graph(int n, int[][] edges) {
            this.n = n;
            this.edges = new int[n][n];
            for (int[] edge : edges) {
                addEdge(edge);
            }
        }

        public void addEdge(int[] edge) {
            this.edges[edge[0]][edge[1]] = edge[2];
        }

        public int shortestPath(int node1, int node2) {
            return dijkstra(node1, node2);
        }

        private int dijkstra(int start, int end) {
            int[] dist = new int[this.n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;

            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            queue.add(new int[]{0, start});

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentNode = current[1];
                int currentCost = current[0];

                if (currentCost > dist[currentNode]) {
                    continue;
                }

                if (currentNode == end) {
                    return currentCost;
                }

                for (int i = 0; i < n; i++) {
                    if (edges[currentNode][i] != 0) {
                        int to = i;
                        int cost = edges[currentNode][i];
                        int costTo = cost + dist[currentNode];

                        if (dist[to] > costTo) {
                            dist[to] = costTo;
                            queue.add(new int[]{costTo, to});
                        }
                    }
                }
            }

            return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
        }
    }
}
