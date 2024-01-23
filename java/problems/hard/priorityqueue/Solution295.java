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
        PriorityQueue<Integer> small;
        PriorityQueue<Integer> large;
        boolean isEven = true;

        public MedianFinder() {
            small = new PriorityQueue<>(Collections.reverseOrder());
            large = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (isEven) {
                large.offer(num);
                small.offer(large.poll());
            } else {
                small.offer(num);
                large.offer(small.poll());
            }
            isEven = !isEven;
        }

        public double findMedian() {
            return isEven ? (small.peek() + large.peek()) / 2.0 : small.peek();
        }
    }
}
