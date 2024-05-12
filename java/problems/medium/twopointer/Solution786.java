package problems.medium.twopointer;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/k-th-smallest-prime-fraction">
 * k-th-smallest-prime-fraction</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int[] res = new int[2];
        double l = 0;
        double r = 1;
        double mid;
        while (l <= r) {
            mid = (l + r) / 2;
            int j = 1;
            int currLessNumber = 0;
            int num = 0;
            int den = 0;
            double maxFrac = 0;
            for (int i = 0; i < arr.length; i++) {
                while (j < arr.length && (double) arr[i] / arr[j] >= mid) {
                    j++;
                }
                currLessNumber += arr.length - j;
                if (j < arr.length && maxFrac < arr[i] * 1.0 / arr[j]) {
                    maxFrac = arr[i] * 1.0 / arr[j];
                    num = i;
                    den = j;
                }
            }
            if (currLessNumber == k) {
                return new int[]{arr[num], arr[den]};
            } else if (currLessNumber < k) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return res;
    }

    public int[] kthSmallestPrimeFraction1(int[] arr, int k) {
        int n = arr.length;
        double left = 0, right = 1, mid;
        int[] res = new int[2];

        while (left <= right) {
            mid = left + (right - left) / 2;
            int j = 1, total = 0, num = 0, den = 0;
            double maxFrac = 0;
            for (int i = 0; i < n; ++i) {
                while (j < n && arr[i] >= arr[j] * mid) {
                    ++j;
                }
                total += n - j;
                if (j < n && maxFrac < arr[i] * 1.0 / arr[j]) {
                    maxFrac = arr[i] * 1.0 / arr[j];
                    num = i;
                    den = j;
                }
            }
            if (total == k) {
                res[0] = arr[num];
                res[1] = arr[den];
                break;
            }

            if (total > k) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return res;
    }

    public int[] kthSmallestPrimeFraction2(int[] arr, int k) {
        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                priorityQueue.add(new double[]{(double) arr[i] / arr[j], arr[i], arr[j]});
            }
        }
        k--;
        while (k-- > 0) {
            priorityQueue.poll();
        }
        return new int[]{(int) priorityQueue.peek()[1], (int) priorityQueue.peek()[2]};
    }
}
