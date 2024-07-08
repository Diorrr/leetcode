package problems.medium.stack;


import java.util.LinkedList;

/**
 * Problem: <a href="https://leetcode.com/problems/find-the-winner-of-the-circular-game">
 * find-the-winner-of-the-circular-game</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1823 {
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        int index = 0;
        while (list.size() > 1) {
            int toDeleteIndex = (index + k - 1) % list.size();
            list.remove(toDeleteIndex);
            index = toDeleteIndex;
        }

        return list.getFirst();
    }

    public int findTheWinner2(int n, int k) {
        boolean[] eliminated = new boolean[n];
        int start = 0;
        int toLeave = 1;
        while (n > 1) {
            start %= eliminated.length;
            toLeave %= k;
            if (toLeave == 0 && !eliminated[start]) {
                eliminated[start] = true;
                toLeave = 1;
                n--;
            }
            if (!eliminated[start]) {
                toLeave++;
            }
            start++;
        }
        for (int i = 0; i < eliminated.length; i++) {
            if (!eliminated[i]) {
                return i + 1;
            }
        }
        return 0;
    }
}
