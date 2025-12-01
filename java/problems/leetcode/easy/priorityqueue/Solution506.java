package problems.leetcode.easy.priorityqueue;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/relative-ranks">
 * relative-ranks</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution506 {
    public String[] findRelativeRanks(int[] score) {
        String[] ranks = new String[score.length];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0])));
        for (int i = 0; i < score.length; i++) {
            queue.add(new int[]{score[i], i});
        }
        int position = ranks.length;
        while (position > 3) {
            ranks[queue.poll()[1]] = String.valueOf(position--);
        }
        if (queue.size() == 3) {
            ranks[queue.poll()[1]] = "Bronze Medal";
        }
        if (queue.size() == 2) {
            ranks[queue.poll()[1]] = "Silver Medal";
        }
        if (queue.size() == 1) {
            ranks[queue.poll()[1]] = "Gold Medal";
        }
        return ranks;
    }

    public static void main(String[] args) {

    }
}
