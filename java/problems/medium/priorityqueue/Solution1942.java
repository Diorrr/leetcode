package problems.medium.priorityqueue;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair">
 * the-number-of-the-smallest-unoccupied-chair</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1942 {
    public int smallestChair(int[][] times, int targetFriend) {
        int[] target = times[targetFriend];
        int res = 0;
        Arrays.sort(times, Comparator.comparingInt(a -> (a[0])));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0])));
        PriorityQueue<Integer> chairQueue = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            chairQueue.add(i);
        }
        for (int[] time : times) {
            while (!queue.isEmpty() && queue.peek()[0] <= time[0]) {
                chairQueue.add(queue.poll()[1]);
            }
            if (time[0] == target[0] && time[1] == target[1]) {
                return chairQueue.peek();
            } else {
                queue.add(new int[]{time[1], chairQueue.poll()});
            }
        }
        return res;
    }
}
