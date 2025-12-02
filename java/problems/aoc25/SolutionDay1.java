package problems.aoc25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem: <a href="https://adventofcode.com/2025/day/1">
 * day1</a>
 * Time Complexity:
 * Space Complexity：
 */
class SolutionDay1 {

    void solve1() {
        int res = 0;
        int dial = 50;
        String fileName = "java/problems/aoc25/input/dat1.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // read line by line until EOF (null)
            while ((line = reader.readLine()) != null) {
                int rotate = Integer.parseInt(line.substring(1));
                int sign = line.charAt(0) == 'L' ? 1 : -1;
                dial = (dial + sign * rotate + 100) % 100;
                if (dial == 0) {
                    res++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(res);
    }

    void solve2() {
        int res = 0;
        int dial = 50;
        String fileName = "java/problems/aoc25/input/dat1.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // read line by line until EOF (null)
            while ((line = reader.readLine()) != null) {
                int rotate = Integer.parseInt(line.substring(1));
                int sign = line.charAt(0) == 'L' ? -1 : 1;
                res += rotate / 100;
                rotate %= 100;
                if (dial != 0 && (dial + sign * rotate > 100 || dial + sign * rotate < 0)) {
                    res++;
                }
                dial = (dial + sign * rotate + 100) % 100;
                if (dial == 0) {
                    res++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(res);
    }
}
