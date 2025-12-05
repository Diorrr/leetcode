package problems.aoc25;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Problem: <a href="https://adventofcode.com/2025/day/5">
 * day5</a>
 */
class SolutionDay5 {
    void solve2() throws FileNotFoundException {
        BigInteger res = BigInteger.ZERO;
        List<BigInteger[]> ranges = new ArrayList<>();
        List<BigInteger[]> mergedRanges = new ArrayList<>();
        String fileName = "java/problems/aoc25/input/dat5.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // read line by line until EOF (null)
            while ((line = reader.readLine()) != null) {
                ranges.add(getInteval(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ranges.sort(Comparator.comparing(a -> a[0]));
        BigInteger[] current = ranges.get(0);
        mergedRanges.add(current);
        for (BigInteger[] range : ranges) {
            if (range[0].compareTo(current[1])<1){
                current[1]= current[1].max(range[1]);
            } else {
                current = range;
                mergedRanges.add(current);
            }
        }
        for (BigInteger[] mergedRange : mergedRanges) {
            res = res.add(mergedRange[1].subtract(mergedRange[0]).add(BigInteger.ONE));
        }
        System.out.println(res);
    }

    void solve1() throws FileNotFoundException {
        int res = 0;
        List<BigInteger[]> ranges = new ArrayList<>();
        String fileName = "java/problems/aoc25/input/dat5.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // read line by line until EOF (null)
            while ((line = reader.readLine()) != null) {
                if (line.contains("-")) {
                    ranges.add(getInteval(line));
                } else if (!line.isEmpty()) {
                    BigInteger num = new BigInteger(line);
                    if (isAvailable(num, ranges)) {
                        res++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }

    private BigInteger[] getInteval(String line){
        String[] parts = line.split("-");
        BigInteger start = new BigInteger(parts[0].trim());
        BigInteger end = new BigInteger(parts[1].trim());
        return new BigInteger[]{start, end};
    }

    private boolean isAvailable(BigInteger num, List<BigInteger[]> range) {
        for (BigInteger[] ints : range) {
            if (num.compareTo(ints[0]) > -1 && num.compareTo(ints[1]) < 1) {
                return true;
            }
        }
        return false;
    }
}
