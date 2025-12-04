package problems.aoc25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://adventofcode.com/2025/day/4">
 * day4</a>
 */
class SolutionDay4 {

    void solve1() {
        List<char[]> grid = new ArrayList<>();
        String fileName = "java/problems/aoc25/input/dat4.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // read line by line until EOF (null)
            while ((line = reader.readLine()) != null) {
                grid.add(line.toCharArray());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        calc2(grid);
    }

    private void calc1(List<char[]> grid) {
        int res = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).length; j++) {
                if (grid.get(i)[j] == '@') {
                    int count = countAccessible(grid, i, j);
                    if (count < 4) {
                        res++;
                    }
                }
            }
        }

        System.out.println(res);
    }

    private void calc2(List<char[]> grid) {
        int res = 0;
        boolean isFound = true;
        while (isFound) {
            isFound = false;
            for (int i = 0; i < grid.size(); i++) {
                for (int j = 0; j < grid.get(i).length; j++) {
                    if (grid.get(i)[j] == '@') {
                        int count = countAccessible(grid, i, j);
                        if (count < 4) {
                            isFound = true;
                            grid.get(i)[j] = 'X';
                            res++;
                        }
                    }
                }
            }
        }

        System.out.println(res);
    }

    private int countAccessible(List<char[]> grid, int i, int j) {
        int count = 0;
        if (i > 0) {
            if (j > 0 && grid.get(i - 1)[j - 1] == '@') {
                count++;
            }
            if (grid.get(i - 1)[j] == '@') {
                count++;
            }
            if (j + 1 < grid.get(i - 1).length && grid.get(i - 1)[j + 1] == '@') {
                count++;
            }
        }
        if (j > 0 && grid.get(i)[j - 1] == '@') {
            count++;
        }
        if (j + 1 < grid.get(i).length && grid.get(i)[j + 1] == '@') {
            count++;
        }
        if (i + 1 < grid.size()) {
            if (j > 0 && grid.get(i + 1)[j - 1] == '@') {
                count++;
            }
            if (grid.get(i + 1)[j] == '@') {
                count++;
            }
            if (j + 1 < grid.get(i + 1).length && grid.get(i + 1)[j + 1] == '@') {
                count++;
            }
        }
        return count;
    }
}
