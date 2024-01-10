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
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                res[i - (k - 1)] = nums[queue.peek()];
            }
        }
        return res;
    }

    int[] t;

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        t = new int[4 * n];
        int[] res = new int[n - k + 1];
        build(nums, 1, 0, n - 1);
        for (int i = k - 1; i < n; i++) {
            res[i - k + 1] = findMax(1, 0, n - 1, i - k + 1, i);
        }
        return res;
    }

    private int findMax(int v, int tl, int tr, int l, int r) {
        if (l > r)
            return 0;
        if (l == tl && r == tr)
            return t[v];
        int tm = (tl + tr) / 2;
        return Math.max(findMax(v * 2, tl, tm, l, Math.min(r, tm)),
                findMax(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r));
    }

    private void build(int[] nums, int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = nums[tl];
        } else {
            int tm = (tl + tr) / 2;
            build(nums, v * 2, tl, tm);
            build(nums, v * 2 + 1, tm + 1, tr);
            t[v] = Math.max(t[v * 2], t[v * 2 + 1]);
        }
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1])
        );
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i], i});
        }
        for (int i = k - 1; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek()[1] <= i - k) {
                queue.poll();
            }
            queue.add(new int[]{nums[i], i});
            res[i - (k - 1)] = queue.peek()[0];
        }

        return res;
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
