package problems.leetcode.medium.priorityqueue;


import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves">
 * minimum-difference-between-largest-and-smallest-value-in-three-moves</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1509 {
    public int minDifference(int[] nums) {
        if (nums.length < 5) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            if (pq.size() < 4) {
                pq.add(num);
            } else if (pq.size() == 4 && pq.peek() < num) {
                pq.poll();
                pq.add(num);
            }
            if (pqDesc.size() < 4) {
                pqDesc.add(num);
            } else if (pqDesc.size() == 4 && pqDesc.peek() > num) {
                pqDesc.poll();
                pqDesc.add(num);
            }
        }
        int[] mins = new int[4];
        int[] maxs = new int[4];
        for (int i = 0; i < 4; i++) {
            mins[i] = pqDesc.poll();
            maxs[3 - i] = pq.poll();
        }
        for (int i = 0; i < 4; i++) {
            res = Math.min(maxs[i] - mins[i], res);
        }
        return res;
    }

    public int minDifference2(int[] nums) {
        if (nums.length < 5) {
            return 0;
        }
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            res = Math.min(nums[nums.length - i - 1] - nums[3 - i], res);
        }
        return res;
    }
}
