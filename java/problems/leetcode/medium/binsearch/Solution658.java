package problems.leetcode.medium.binsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/find-k-closest-elements/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();

        int l = 0, r = arr.length - 1;
        int m = 0;
        while (l <= r) {
            m = (r + l) / 2;
            if (arr[m] == x) {
                break;
            } else if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (m > 0 && Math.abs(arr[m - 1] - x) <= Math.abs(arr[m] - x)) {
            m--;
        } else if (m + 1 < arr.length && Math.abs(arr[m + 1] - x) < Math.abs(arr[m] - x)) {
            m++;
        }
        res.add(arr[m]);
        k--;
        l = m - 1;
        r = m + 1;
        while (k > 0) {
            if (l < 0) {
                res.add(arr[r]);
                r++;
            } else if (r > arr.length - 1) {
                res.add(arr[l]);
                l--;
            } else if (Math.abs(arr[l] - x) == Math.abs(arr[r] - x)) {
                res.add(arr[l]);
                l--;
            } else if (Math.abs(arr[l] - x) < Math.abs(arr[r] - x)) {
                res.add(arr[l]);
                l--;
            } else {
                res.add(arr[r]);
                r++;
            }
            k--;
        }
        Collections.sort(res);
        return res;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();

        int l = 0, r = arr.length - 1;
        int min = Math.abs(arr[0] - x);
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - x) < min) {
                min = Math.abs(arr[i] - x);
                index = i;
            }
        }

        res.add(arr[index]);
        k--;
        l = index - 1;
        r = index + 1;
        while (k > 0) {
            if (l < 0) {
                res.add(arr[r]);
                r++;
            } else if (r > arr.length - 1) {
                res.add(arr[l]);
                l--;
            } else if (Math.abs(arr[l] - x) == Math.abs(arr[r] - x)) {
                res.add(arr[l]);
                l--;
            } else if (Math.abs(arr[l] - x) < Math.abs(arr[r] - x)) {
                res.add(arr[l]);
                l--;
            } else {
                res.add(arr[r]);
                r++;
            }
            k--;
        }
        Collections.sort(res);
        return res;
    }
}
