package problems.medium.stack;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 * Problem: <a href="link">
 * problem</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        HashMap<Integer, Deque<Integer>> positionMap = new HashMap<>();
        for (int i = 0; i < temperatures.length; i++) {
            positionMap.putIfAbsent(temperatures[i], new ArrayDeque<>());
            positionMap.get(temperatures[i]).add(i);
        }

        for (int i = 0; i < temperatures.length; i++) {
            int minPos = Integer.MAX_VALUE;
            for (int j = temperatures[i] + 1; j <= 100; j++) {
                if (positionMap.get(j) != null) {
                    while (!positionMap.get(j).isEmpty() && positionMap.get(j).peek() < i) {
                        positionMap.get(j).pop();
                    }
                    if (!positionMap.get(j).isEmpty()) {
                        minPos = Math.min(positionMap.get(j).peek(), minPos);
                    }
                }
            }
            res[i] = minPos == Integer.MAX_VALUE ? 0 : minPos - i;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution739().dailyTemperatures(
                        new int[]{
                                73, 74, 75, 71, 69, 72, 76, 73
                        }
                ))
        );
    }
}
