package problems.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/happy-number/
 * Time Complexity:
 * Space Complexity：
 */
class Solution202 {
    //from solutions with Set
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = String.valueOf(n).chars()
                      .mapToObj(c -> String.valueOf((char) c))
                      .map(Integer::parseInt)
                      .map(t -> t * t)
                      .mapToInt(Integer::intValue)
                      .sum();
        }
        return n == 1;
    }

    public boolean isHappy2(int n) {
        int[] count = new int[1000];
        int k = 0;
        while (k < 1000) {
            if (n == 1) {
                return true;
            }
            if (n <= 1000) {
                if (count[n] > 0) {
                    return false;
                }
                count[n]++;
            }
            k++;
            n = String.valueOf(n).chars()
                      .mapToObj(c -> String.valueOf((char) c))
                      .map(Integer::parseInt)
                      .map(t -> t * t)
                      .mapToInt(Integer::intValue)
                      .sum();
        }
        return false;
    }
}
