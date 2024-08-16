package problems.medium.greedy;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-distance-in-arrays">
 * maximum-distance-in-arrays</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        int min1st = Integer.MAX_VALUE;
        int min2nd = Integer.MAX_VALUE;
        int max1st = Integer.MIN_VALUE;
        int max2nd = Integer.MIN_VALUE;
        int indexMin1st = -1;
        int indexMin2nd = -1;
        int indexMax1st = -1;
        int indexMax2nd = -1;
        for (int i = 0; i < arrays.size(); i++) {
            for (Integer elem : arrays.get(i)) {
                if (elem < min1st) {
                    min1st = elem;
                    indexMin1st = i;
                }
                if (elem > max1st) {
                    max1st = elem;
                    indexMax1st = i;
                }
            }
        }
        for (int i = 0; i < arrays.size(); i++) {
            for (Integer elem : arrays.get(i)) {
                if (elem < min2nd && i != indexMin1st) {
                    min2nd = elem;
                    indexMin2nd = i;
                }
                if (elem > max2nd && i != indexMax1st) {
                    max2nd = elem;
                    indexMax2nd = i;
                }
            }
        }
        if (indexMin1st != indexMax1st) {
            res = max1st - min1st;
        } else {
            if (indexMax1st != indexMin2nd) {
                res = max1st - min2nd;
            }
            if (indexMax2nd != indexMin1st) {
                res = Math.max(max2nd - min1st, res);
            }
            if (indexMax2nd != indexMin2nd) {
                res = Math.max(max2nd - min2nd, res);
            }
        }
        return res;
    }

    public int maxDistance2(List<List<Integer>> arrays) {
        int res = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0])));
        PriorityQueue<int[]> queueRev = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).reversed());
        for (int i = 0; i < arrays.size(); i++) {
            for (Integer elem : arrays.get(i)) {
                queue.add(new int[]{elem, i});
                queueRev.add(new int[]{elem, i});
            }
        }
        if (queue.peek()[1] != queueRev.peek()[1]) {
            res = Math.max(res, queueRev.peek()[0] - queue.peek()[0]);
        } else {
            int[] min = queue.poll();
            while (queue.peek()[1] == queueRev.peek()[1]) {
                queue.poll();
            }
            res = queueRev.peek()[0] - queue.peek()[0];
            while (min[1] == queueRev.peek()[1]) {
                queueRev.poll();
            }
            res = Math.max(queueRev.peek()[0] - min[0], res);
        }

        return res;
    }
}
