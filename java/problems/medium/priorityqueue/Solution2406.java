package problems.medium.priorityqueue;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups">
 * divide-intervals-into-minimum-number-of-groups</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2406 {
    public int minGroups(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && pq.peek() < interval[0]) {
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }

    public int minGroups2(int[][] intervals) {
        int res = 0;
        int[] start = Arrays.stream(intervals).mapToInt(i -> i[0]).toArray();
        int[] end = Arrays.stream(intervals).mapToInt(i -> i[1]).toArray();
        Arrays.sort(start);
        Arrays.sort(end);
        int r = 0;
        for (int l : start) {
            if (l > end[r]) {
                r++;
            } else {
                res++;
            }
        }
        return res;
    }
}
