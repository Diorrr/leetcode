package problems.leetcode.medium.bfs;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/cheapest-flights-within-k-stops">
 * cheapest-flights-within-k-stops</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        k++;

        while (!queue.isEmpty() && k-- > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                if (adj.containsKey(curr[0])) {
                    for (int[] neighbor : adj.get(curr[0])) {
                        int newPrice = curr[1] + neighbor[1];
                        if (newPrice < visited[neighbor[0]]) {
                            visited[neighbor[0]] = newPrice;
                            queue.offer(new int[]{neighbor[0], newPrice});
                        }
                    }
                }
            }
        }

        return visited[dst] == Integer.MAX_VALUE ? -1 : visited[dst];
    }
}
