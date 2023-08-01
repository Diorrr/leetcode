package problems.easy.twopointer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/merge-sorted-array">
 * merge-sorted-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution88 {
    // solution from comments
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.addAll(Arrays.stream(nums2).boxed().toList());

        for (int i = 0; i < m; i++) {
            int number = queue.peek();
            if (nums1[i] > number) {
                queue.poll();
                int t = nums1[i];
                nums1[i] = number;
                queue.add(t);
            }
        }

        for (int i = m; i < nums1.length; i++) {
            nums1[i] = queue.poll();
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - nums2.length; i < nums1.length; i++) {
            nums1[i] = nums2[i - (nums1.length - nums2.length)];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        new Solution88().merge(
                new int[]{4, 5, 6, 0, 0, 0},
                3,
                new int[]{1, 2, 3},
                3
        );
    }
}
