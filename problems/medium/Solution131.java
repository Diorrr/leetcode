package problems.medium;

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
        backtrack(s, 0, new ArrayList<String>());
        return res;
    }

    private void backtrack(String original, int index, List<String> strings) {
        if (index + 1 > original.length()) {
            res.add(strings);
        } else if (index < original.length()) {
            for (int i = 1; index + i <= original.length(); i++) {
                if (isPalindrome(original.substring(index, index + i))) {
                    List<String> temp = new ArrayList<>(strings);
                    temp.add(original.substring(index, index + i));
                    backtrack(original, index + i, temp);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }
}
