package problems.medium.priorityqueue;


import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/furthest-building-you-can-reach">
 * furthest-building-you-can-reach</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderQueue = new PriorityQueue<>();
        int sumBricks = 0;
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                if (ladderQueue.size() < ladders) {
                    ladderQueue.add(diff);
                } else if (ladderQueue.size() > 0 && ladderQueue.peek() < diff && sumBricks + ladderQueue.peek() <= bricks) {
                    int subst = ladderQueue.poll();
                    sumBricks += subst;
                    ladderQueue.add(diff);
                } else if (sumBricks + diff <= bricks) {
                    sumBricks += diff;
                } else {
                    return i-1;
                }
            }
        }

        return heights.length - 1;
    }

    public int furthestBuilding2(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                ladderQueue.add(diff);
            }
            if (ladderQueue.size() > ladders) {
                bricks -= ladderQueue.poll();
            }
            if (bricks < 0) {
                return i;
            }
        }

        return heights.length - 1;
    }
}
