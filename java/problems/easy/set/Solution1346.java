package problems.easy.set;


import java.util.HashSet;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/check-if-n-and-its-double-exist">
 * check-if-n-and-its-double-exist</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1346 {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
