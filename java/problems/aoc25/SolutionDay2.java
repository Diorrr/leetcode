package problems.aoc25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Problem: <a href="https://adventofcode.com/2025/day/2">
 * day2</a>
 * Time Complexity:
 * Space Complexity：
 */
class SolutionDay2 {

    void solve1() {
        AtomicLong res = new AtomicLong();
        String fileName = "java/problems/aoc25/input/dat2.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // read line by line until EOF (null)
            while ((line = reader.readLine()) != null) {
                Arrays.stream(line.split(","))
                      .forEach(range -> {
                          String[] nums = range.split("-");
                          long start = Long.parseLong(nums[0]);
                          long end = Long.parseLong(nums[1]);
                          for (long i = start; i <= end; i++) {
                              if (isInvalid(i)) {
                                  res.addAndGet(i);
                              }
                          }
                      });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(res.get());
    }

    private boolean isInvalid(long num) {
        String s = String.valueOf(num);
        return s.equals(s.substring(0, s.length() / 2).repeat(2));
    }

    private boolean isInvalid2(long num) {
        String s = String.valueOf(num);
        for (int times = 2; times <= s.length(); times++) {
            if (s.length() % times == 0) {
                String repeat = s.substring(0, s.length() / times).repeat(times);
                if (s.equals(repeat)) {
                    return true;
                }
            }
        }
        return false;
    }
}
