package problems.medium.greedy;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/hand-of-straights">
 * hand-of-straights</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != -1) {
                int index = i;
                int value = hand[i];
                int rest = groupSize;
                while (rest > 0 && index < hand.length) {
                    if (hand[index] == value) {
                        hand[index] = -1;
                        value++;
                        rest--;
                    }
                    index++;
                }
                if (rest != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isNStraightHand2(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int[] nums = Arrays.stream(hand).distinct().sorted().toArray();
        for (int num : nums) {
            while (count.get(num) > 0) {
                for (int i = 0; i < groupSize; i++) {
                    if (count.getOrDefault(num + i, 0) > 0) {
                        count.put(num + i, count.get(num + i) - 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
