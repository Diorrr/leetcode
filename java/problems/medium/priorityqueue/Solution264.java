package problems.medium.priorityqueue;


import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/ugly-number-ii">
 * ugly-number-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution264 {
    public int nthUglyNumber(int n) {
        long res = 1;
        int[] primes = new int[]{2,3,5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        set.add(1L);
        queue.add(1L);
        for (int i = 0; i < n; i++) {
            res = queue.poll();
            for (int prime : primes) {
                long toAdd = res * prime;
                if (!set.contains(toAdd)) {
                    set.add(toAdd);
                    queue.add(toAdd);
                }
            }
        }
        return (int) res;
    }
}
