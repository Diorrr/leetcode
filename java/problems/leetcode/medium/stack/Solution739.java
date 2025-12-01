package problems.leetcode.medium.stack;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/daily-temperatures">
 * daily-temperatures</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
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
}
