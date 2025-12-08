package problems.aoc25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Problem: <a href="https://adventofcode.com/2025/day/8">
 * day8</a>
 */
class SolutionDay8 {
    private void solve1() {
        List<List<Long>> grid = new ArrayList<>();
        String fileName = "java/problems/aoc25/input/dat8.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // read line by line until EOF (null)
            while ((line = reader.readLine()) != null) {
                grid.add(Arrays.stream(line.split(",")).map(Long::valueOf).toList());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        calc1(grid);
    }

    private void calc1(List<List<Long>> grid) {
        int res1 = 0;
        int circuitIndex = 0;
        int[] circuitAssignments = new int[grid.size()];
        PriorityQueue<List<Long>> queue = new PriorityQueue<>(Comparator.comparingLong(o -> o.get(0)));
        long[][] dist = new long[grid.size()][grid.size()];
        for (int i = 0; i < grid.size(); i++) {
            for (int j = i + 1; j < grid.size(); j++) {
                long distance = getDisc(grid.get(i), grid.get(j));
                dist[i][j] = distance;
                dist[j][i] = distance;
                queue.add(List.of(distance, (long) i, (long) j));
            }
        }
        int l1 = 0, l2 = 0;
        while (!queue.isEmpty()) {
            List<Long> curr = queue.poll();
            int point1 = curr.get(1).intValue();
            int point2 = curr.get(2).intValue();
            if (circuitAssignments[point1] != 0 && circuitAssignments[point1] == circuitAssignments[point2]) {
                continue;
            }
            l1=point1;
            l2=point2;
            if (circuitAssignments[point1] == 0 && circuitAssignments[point2] == 0) {
                circuitIndex++;
                circuitAssignments[point1] = circuitIndex;
                circuitAssignments[point2] = circuitIndex;
            } else if (circuitAssignments[point1] != 0 && circuitAssignments[point2] == 0) {
                circuitAssignments[point2] = circuitAssignments[point1];
            } else if (circuitAssignments[point1] == 0 && circuitAssignments[point2] != 0) {
                circuitAssignments[point1] = circuitAssignments[point2];
            } else if (circuitAssignments[point1] != circuitAssignments[point2]) {
                int circuitAssignment1 = circuitAssignments[point1];
                for (int j = 0; j < circuitAssignments.length; j++) {
                    if (circuitAssignments[j] == circuitAssignment1) {
                        circuitAssignments[j] = circuitAssignments[point2];
                    }
                }
            }
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer number : circuitAssignments) {
            if (number != 0) {
                int count = frequencyMap.getOrDefault(number, 0);
                frequencyMap.put(number, count + 1);
            }
        }
        PriorityQueue<Integer> queueSize = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer value : frequencyMap.values()) {
            queueSize.add(value);
        }
//        res1 = queueSize.poll() * queueSize.poll() * queueSize.poll();
        System.out.println(grid.get(l1).get(0)*grid.get(l2).get(0));
    }

    private long getDisc(List<Long> point1, List<Long> point2) {
        return (long) (Math.pow(point1.get(0) - point2.get(0), 2)
                + Math.pow(point1.get(1) - point2.get(1), 2)
                + Math.pow(point1.get(2) - point2.get(2), 2));
    }
}
