package problems.aoc25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: <a href="https://adventofcode.com/2025/day/6">
 * day6</a>
 */
class SolutionDay6 {
    private void solve1() {
        List<List<BigInteger>> ranges = new ArrayList<>();
        List<String> operations = new ArrayList<>();
        String fileName = "java/problems/aoc25/input/dat6.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // read line by line until EOF (null)
            while ((line = reader.readLine()) != null) {
                if (line.contains("+") || line.contains("*")) {
                    operations = Arrays.stream(line.trim().split("\\s+")).toList();
                } else {
                    ranges.add(Arrays.stream(line.trim().split("\\s+")).map(BigInteger::new).toList());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        calc(ranges, operations);
    }

    private void calc(List<List<BigInteger>> ranges, List<String> operations) {
        BigInteger res = BigInteger.ZERO;
        for (int i = 0; i < ranges.get(0).size(); i++) {
            BigInteger currSum = operations.get(i).equals("+") ? BigInteger.ZERO : BigInteger.ONE;
            for (List<BigInteger> range : ranges) {
                if (operations.get(i).equals("+")) {
                    currSum = currSum.add(range.get(i));
                } else {
                    currSum = currSum.multiply(range.get(i));
                }
            }
            res = res.add(currSum);
        }
        System.out.println(res);
    }

    private void solve2() {
        List<char[]> grid = new ArrayList<>();
        List<int[]> operations = new ArrayList<>();
        String fileName = "java/problems/aoc25/input/dat6.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // read line by line until EOF (null)
            while ((line = reader.readLine()) != null) {
                if (line.contains("+") || line.contains("*")) {
                    for (int i = 0; i < line.toCharArray().length; i++) {
                        if (line.charAt(i) == '+') {
                            operations.add(new int[]{i, 0});
                        } else if (line.charAt(i) == '*') {
                            operations.add(new int[]{i, 1});
                        }
                    }
                } else {
                    grid.add(line.toCharArray());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        calc2(grid, operations);
    }

    private void calc2(List<char[]> grid, List<int[]> operations) {
        BigInteger res = BigInteger.ZERO;
        int maxLen = grid.stream().mapToInt(chars -> chars.length).max().getAsInt();
        for (int i = 0; i < operations.size(); i++) {
            int start = operations.get(i)[0];
            int end = i + 1 < operations.size() ? operations.get(i + 1)[0] - 1 : maxLen;
            BigInteger currSum = operations.get(i)[1] == 0 ? BigInteger.ZERO : BigInteger.ONE;
            for (int j = start; j < end; j++) {
                StringBuilder sb = new StringBuilder();
                for (char[] chars : grid) {
                    if (j < chars.length && chars[j] != ' ') {
                        sb.append(chars[j]);
                    }
                }
                if (operations.get(i)[1] == 0) {
                    currSum = currSum.add(new BigInteger(sb.toString()));
                } else {
                    currSum = currSum.multiply(new BigInteger(sb.toString()));
                }
            }
            res = res.add(currSum);
        }

        System.out.println(res);
    }
}
