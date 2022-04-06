package problems.medium;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/3sum-with-multiplicity/
 * Time Complexity: O(N^2)
 * Space Complexity：
 */
class Solution923 {
    // from solutions
    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1_000_000_007;
        long res = 0;
        long[] count = new long[101];
        Arrays.stream(arr).forEach(t -> count[t]++);

        // x != y != z
        for (int x = 0; x <= 100; ++x) {
            for (int y = x + 1; y <= 100; ++y) {
                int z = target - x - y;
                if (y < z && z <= 100) {
                    res += count[x] * count[y] * count[z];
                    res %= MOD;
                }
            }
        }

        // x == y != z
        for (int x = 0; x <= 100; ++x) {
            int z = target - 2 * x;
            if (x < z && z <= 100) {
                res += count[x] * (count[x] - 1) * count[z] / 2;
                res %= MOD;
            }
        }

        // x != y == z
        for (int x = 0; x <= 100; ++x) {
            if ((target - x) % 2 == 0) {
                int z = (target - x) / 2;
                if (x < z && z <= 100) {
                    res += count[z] * (count[z] - 1) * count[x] / 2;
                    res %= MOD;
                }
            }
        }

        // x == y == z
        if (target % 3 == 0) {
            int z = target / 3;
            if (z <= 100) {
                res += count[z] * (count[z] - 1) * (count[z] - 2) / 6;
                res %= MOD;
            }
        }

        return (int) res;
    }
}