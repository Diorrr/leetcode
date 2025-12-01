package problems.leetcode.medium.bfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/find-all-groups-of-farmland">
 * find-all-groups-of-farmland</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1992 {
    public int[][] findFarmland(int[][] land) {
        List<int[]> coordinates = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1) {
                    coordinates.add(new int[]{i, j, i, j});
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i);
                    queue.add(j);
                    while (!queue.isEmpty()) {
                        int x = queue.poll();
                        int y = queue.poll();
                        coordinates.get(coordinates.size() - 1)[2] = x;
                        coordinates.get(coordinates.size() - 1)[3] = y;
                        land[x][y] = 0;
                        if (x + 1 < land.length && land[x + 1][y] == 1) {
                            queue.add(x + 1);
                            queue.add(y);
                        }
                        if (y + 1 < land[x].length && land[x][y + 1] == 1) {
                            queue.add(x);
                            queue.add(y + 1);
                        }
                    }
                }
            }
        }
        int[][] res = new int[coordinates.size()][];
        return coordinates.toArray(res);
    }
    public int[][] findFarmland2(int[][] land) {
        List<int[]> coordinates = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1) {
                    int[] curr = new int[]{i, j, i, j};
                    int x = i;
                    int y = j;
                    while (x + 1 < land.length && land[x + 1][y] == 1) {
                        x++;
                    }
                    while (y + 1 < land[x].length && land[x][y + 1] == 1) {
                        y++;
                    }
                    curr[2] = x;
                    curr[3] = y;
                    for (int k = i; k <= x; k++) {
                        for (int l = j; l <= y; l++) {
                            land[k][l] = 0;
                        }
                    }
                    coordinates.add(curr);
                }
            }
        }
        int[][] res = new int[coordinates.size()][];
        return coordinates.toArray(res);
    }
}
