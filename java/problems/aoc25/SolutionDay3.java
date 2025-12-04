package problems.aoc25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem: <a href="https://adventofcode.com/2025/day/3">
 * day3</a>
 * Time Complexity:
 * Space Complexity：
 */
class SolutionDay3 {

    void solve1() {
        long res = 0;
        String fileName = "java/problems/aoc25/input/dat3.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // read line by line until EOF (null)
            while ((line = reader.readLine()) != null) {
                res += getMaxNumber2(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(res);
    }

    private long getMaxNumber2(final String line){
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < 12; i++) {
            int pos = -1;
            char maxChar = '0';
            for (int j = index; j < line.length() - (11 - i); j++) {
                char c = line.charAt(j);
                if (c > maxChar) {
                    maxChar = c;
                    pos = j;
                }
            }
            sb.append(maxChar);
            index = pos + 1;
        }
        return Long.parseLong(sb.toString());
    }
    private int getMaxNumber1(final String line){
        Character first = null;
        Character second = null;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (first == null) {
                first = c;
            } else if (i != line.length()-1 && first < c) {
                first = c;
                second = null;
            } else if (second == null || second < c) {
                second = c;
            }
        }
        return Integer.parseInt(first.toString() + second.toString());
    }
}
