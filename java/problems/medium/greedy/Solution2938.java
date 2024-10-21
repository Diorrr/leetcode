package problems.medium.greedy;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/separate-black-and-white-balls">
 * separate-black-and-white-balls</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2938 {
    public long minimumSteps(String s) {
        long res = 0;
        int ind = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i <= chars.length; i++) {
            if (chars[i - 1] == '0') {
                res += (i - 1 - ind);
                ind++;
            }
        }
        return res;
    }

    public long minimumSteps2(String s) {
        PriorityQueue<Integer> zeros = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> ones = new PriorityQueue<>();
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros.add(i);
            } else {
                ones.add(i);
            }
        }
        while (!zeros.isEmpty() && !ones.isEmpty() && zeros.peek() > ones.peek()) {
            res += zeros.poll() - ones.poll();
        }

        return res;
    }
}
