package problems.medium.arrays;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * Problem: <a href="https://leetcode.com/problems/find-the-winner-of-an-array-game">
 * find-the-winner-of-an-array-game</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1535 {
    public int getWinner(int[] arr, int k) {
        if (k > arr.length) {
            return Arrays.stream(arr).max().getAsInt();
        }
        int res = arr[0];
        int count = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : arr) {
            list.add(num);
        }
        while (count != k) {
            int first = list.pop();
            int second = list.pop();
            if (first > second) {
                res = first;
                count++;
                list.add(second);
                list.addFirst(first);
            } else {
                res = second;
                count = 1;
                list.add(first);
                list.addFirst(second);
            }
        }

        return res;
    }
}
