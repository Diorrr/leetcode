package problems.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/palindrome-partitioning">
 * palindrome-partitioning</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution131 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<String>());
        return res;
    }

    private void backtrack(String original, int index, List<String> strings) {
        if (index == original.length()) {
            res.add(new ArrayList<>(strings));
        } else if (index < original.length()) {
            for (int i = index + 1; i <= original.length(); i++) {
                String substr = original.substring(index, i);
                if (isPalindrome(substr)) {
                    strings.add(substr);
                    backtrack(original, i, strings);
                    strings.remove(strings.size()-1);
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
