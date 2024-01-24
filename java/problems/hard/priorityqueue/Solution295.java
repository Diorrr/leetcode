package problems.hard.priorityqueue;


import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/find-median-from-data-stream">
 * find-median-from-data-stream</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution295 {
    static class MedianFinder {
        PriorityQueue<Integer> large;
        PriorityQueue<Integer> small;
        boolean isEven = true;

        public MedianFinder() {
            large = new PriorityQueue<>(Collections.reverseOrder());
            small = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (isEven) {
                small.offer(num);
                large.offer(small.poll());
            } else {
                large.offer(num);
                small.offer(large.poll());
            }
            isEven = !isEven;
        }

        public double findMedian() {
            return isEven ? (large.peek() + small.peek()) / 2.0 : large.peek();
        }
    }
}
