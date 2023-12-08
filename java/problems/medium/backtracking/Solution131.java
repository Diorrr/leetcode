package problems.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/palindrome-partitioning/
 * Time Complexity:
 * Space Complexity：
 */
class Solution131 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(String original, int index, List<String> strings) {
        if (index == original.length()) {
            res.add(strings);
        } else if (index < original.length()) {
            for (int i = index + 1; i <= original.length(); i++) {
                String substr = original.substring(index, i);
                if (isPalindrome(substr)) {
                    List<String> temp = new ArrayList<>(strings);
                    temp.add(substr);
                    backtrack(original, i, temp);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
