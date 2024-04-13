package problems.medium.linkedlist;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/reveal-cards-in-increasing-order">
 * reveal-cards-in-increasing-order</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] res = new int[deck.length];
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;

        Arrays.sort(deck);
        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            res[queue.poll()] = deck[index];
            index++;
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }

        return res;
    }
}
