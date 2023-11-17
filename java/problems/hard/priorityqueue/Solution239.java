package problems.hard.priorityqueue;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/sliding-window-maximum">
 * sliding-window-maximum</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1])
        );
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i], i});
        }
        res.add(queue.peek()[0]);
        for (int i = k; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek()[1] <= i - k) {
                queue.poll();
            }
            queue.add(new int[]{nums[i], i});
            res.add(queue.peek()[0]);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;
        int pos = -1;
        for (int i = 0; i < k; i++) {
            if (nums[i] >= maxValue) {
                maxValue = nums[i];
                pos = i;
            }
        }
        res.add(maxValue);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= maxValue) {
                maxValue = nums[i];
                pos = i;
            } else if (i - k == pos) {
                maxValue = Integer.MIN_VALUE;
                pos = -1;
                for (int j = i - k + 1; j <= i; j++) {
                    if (nums[j] >= maxValue) {
                        maxValue = nums[j];
                        pos = j;
                    }
                }
            }
            res.add(maxValue);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
