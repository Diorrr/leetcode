package problems.leetcode.easy.design;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream">
 * kth-largest-element-in-a-stream</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution703 {
    class KthLargest {
        PriorityQueue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int num : nums) {
                pq.add(num);
            }
        }

        public int add(int val) {
            pq.add(val);
            while (pq.size() > k) {
                pq.remove();
            }
            return pq.peek();
        }
    }

    class KthLargest2 {
        List<Integer> list;
        int k;

        public KthLargest2(int k, int[] nums) {
            this.k = k;
            list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
        }

        public int add(int val) {
            list.add(val);
            Collections.sort(list);
            return list.get(list.size() - k);
        }
    }
}
