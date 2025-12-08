package problems.aoc25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

/**
 * Problem: <a href="https://adventofcode.com/2025/day/7">
 * day7</a>
 */
class SolutionDay7 {
    private void solve1() {
        List<String> grid = new ArrayList<>();
        String fileName = "java/problems/aoc25/input/dat7.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // read line by line until EOF (null)
            while ((line = reader.readLine()) != null) {
                grid.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        calc2(grid);
    }

    private void calc1(List<String> grid) {
        int res = 0;
        int x;
        int y;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.get(0).length(); i++) {
            if (grid.get(0).charAt(i) == 'S') {
                x = i;
                y = 0;
                queue.add(new int[]{x, y, 0});
            }
        }
        while (!queue.isEmpty()) {
            Map<Integer, Integer> toVisit = new HashMap<>();
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                x = cur[0];
                y = cur[1];
                if (y + 1 < grid.size()) {
                    if (grid.get(y + 1).charAt(x) == '^') {
                        res++;
                        if (x > 0 && grid.get(y + 1).charAt(x - 1) != '^') {
                            toVisit.put(x - 1, y + 1);
                        }
                        if (x + 1 < grid.get(y + 1).length() && grid.get(y + 1).charAt(x + 1) != '^') {
                            toVisit.put(x + 1, y + 1);
                        }
                    } else {
                        toVisit.put(x, y + 1);
                    }
                }
            }
            toVisit.forEach((k, v) -> queue.add(new int[]{k, v}));
        }
        System.out.println(res);
    }

    private void calc2(List<String> grid) {
        long res = 0;
        int c = 0;
        int r = 0;
        long[][] dp = new long[grid.size()][grid.get(0).length()];
        for (int i = 0; i < grid.get(0).length(); i++) {
            if (grid.get(0).charAt(i) == 'S') {
                r = 0;
                c = i;
            }
        }
        dp[r][c] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (grid.get(i).charAt(j) == '^') {
                    if (i + 1 < dp.length && j > 0) {
                        dp[i + 1][j - 1] += dp[i][j];
                    }
                    if (i + 1 < dp.length && j + 1 < dp[i].length) {
                        dp[i + 1][j + 1] += dp[i][j];
                    }
                } else if (i + 1 < dp.length) {
                    dp[i + 1][j] += dp[i][j];
                }

            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            res += dp[dp.length - 1][i];
        }
        System.out.println(res);
    }
}
