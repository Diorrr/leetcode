package problems.aoc25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: <a href="https://adventofcode.com/2025/day/9">
 * day9</a>
 */
class SolutionDay9 {
    private void solve1() {
        List<List<Long>> points = new ArrayList<>();
        String fileName = "java/problems/aoc25/input/dat9.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // read line by line until EOF (null)
            while ((line = reader.readLine()) != null) {
                points.add(Arrays.stream(line.split(",")).map(Long::valueOf).toList());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        calc1(points);
    }

    private void calc1(List<List<Long>> points) {
        long res = 0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                long square = square(points.get(i), points.get(j));
                res = Math.max(res, square);
            }
        }
        System.out.println(res);
    }

    private long square(List<Long> p1, List<Long> p2) {
        return (1 + Math.abs(p1.get(0) - p2.get(0))) * (1 + Math.abs(p1.get(1) - p2.get(1)));
    }
}
