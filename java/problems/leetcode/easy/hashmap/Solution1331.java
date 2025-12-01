package problems.leetcode.easy.hashmap;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/rank-transform-of-an-array">
 * rank-transform-of-an-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1331 {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[] copy = Arrays.copyOf(arr, arr.length);
        HashMap<Integer, Integer> rank = new HashMap<>();
        Arrays.sort(copy);
        for (int num : copy) {
            rank.putIfAbsent(num, rank.size() + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }

        return arr;
    }

    public int[] arrayRankTransform1(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[][] arrWithIndex = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            arrWithIndex[i] = new int[]{arr[i], i};
        }
        Arrays.sort(arrWithIndex, Comparator.comparingInt(a -> a[0]));
        int rank = 1;
        arr[arrWithIndex[0][1]] = rank;

        for (int i = 1; i < arrWithIndex.length; i++) {
            if (arrWithIndex[i][0] != arrWithIndex[i - 1][0]) {
                rank++;
            }
            arr[arrWithIndex[i][1]] = rank;
        }

        return arr;
    }

    public int[] arrayRankTransform2(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0])));
        for (int i = 0; i < arr.length; i++) {
            queue.add(new int[]{arr[i], i});
        }
        int rank = 1;
        int[] curr = queue.poll();
        int prev = curr[0];
        arr[curr[1]] = rank;

        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr[0] != prev) {
                rank++;
            }
            prev = arr[curr[1]];
            arr[curr[1]] = rank;
        }

        return arr;
    }
}
