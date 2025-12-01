package problems.leetcode.medium.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem: https://leetcode.com/problems/zigzag-conversion/
 * Time Complexity:
 * Space Complexity：
 */
class Solution6 {
    public String convert(String s, int numRows) {
        int length = s.length();
        if (numRows == 1 || length <= numRows) {
            return s;
        }
        List<Character> res = new ArrayList<>();

        int cycle = 2 * numRows - 2;
        for (int i = 0; i * cycle < length; i++) {
            res.add(s.charAt(i * cycle));
        }

        for (int i = 1; i < numRows - 1; i++) {
            res.add(s.charAt(i));
            for (int j = 1; cycle * j - i < length || cycle * j + i < length; j++) {
                if (cycle * j - i < length) {
                    res.add(s.charAt(cycle * j - i));
                }
                if (cycle * j + i < length) {
                    res.add(s.charAt(cycle * j + i));
                }
            }
        }

        for (int i = 0; i * cycle + numRows - 1 < length; i++) {
            res.add(s.charAt(i * cycle + numRows - 1));
        }

        return res.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<List<Character>> level = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            level.add(new ArrayList<>());
        }

        for (int i = 0; i < s.length(); i++) {
            int index = i % (2 * numRows - 2) < numRows ? i % (2 * numRows - 2) : (2 * numRows - 2) - i % (2 * numRows - 2);
            level.get(index).add(s.charAt(i));
        }

        return level.stream()
                .map(t -> t.stream().map(String::valueOf).collect(Collectors.joining()))
                .collect(Collectors.joining());
    }
}
