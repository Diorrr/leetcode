package problems.medium.greedy;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-swap">
 * maximum-swap</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution670 {
    public int maximumSwap(int num) {
        char[] orig = String.valueOf(num).toCharArray();
        for (int i = 0; i < orig.length; i++) {
            int ind = -1;
            char max = orig[i];
            for (int j = orig.length - 1; j > i; j--) {
                if (max < orig[j]) {
                    max = orig[j];
                    ind = j;
                }
            }
            if (ind != -1) {
                char t = orig[i];
                orig[i] = orig[ind];
                orig[ind] = t;
                return Integer.parseInt(String.valueOf(orig));
            }
        }
        return Integer.parseInt(String.valueOf(orig));
    }

    public int maximumSwap2(int num) {
        char[] orig = String.valueOf(num).toCharArray();
        char[] sort = String.valueOf(num).toCharArray();
        Arrays.sort(sort);
        for (int i = 0; i < orig.length; i++) {
            if (orig[i] != sort[sort.length - 1 - i]) {
                for (int j = orig.length - 1; j > i; j--) {
                    if (orig[j] == sort[sort.length - 1 - i]) {
                        orig[j] = orig[i];
                        orig[i] = sort[sort.length - 1 - i];
                        return Integer.parseInt(String.valueOf(orig));
                    }
                }
            }
        }
        return Integer.parseInt(String.valueOf(orig));
    }
}
