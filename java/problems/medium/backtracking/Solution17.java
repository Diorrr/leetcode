package problems.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number">
 * letter-combinations-of-a-phone-number</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution17 {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int index, StringBuilder combination) {
        if (combination.length() == digits.length()) {
            res.add(combination.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        char startChar;
        if (digit < 7) {
            startChar = (char) ('a' + (digit - 2) * 3);
        } else if (digit == 7) {
            startChar = 'p';
            backtrack(digits, index + 1, new StringBuilder(combination).append((char) (startChar + 3)));
        } else if (digit == 8) {
            startChar = 't';
        } else {
            startChar = 'w';
            backtrack(digits, index + 1, new StringBuilder(combination).append((char) (startChar + 3)));
        }
        backtrack(digits, index + 1, new StringBuilder(combination).append(startChar));
        backtrack(digits, index + 1, new StringBuilder(combination).append((char) (startChar + 1)));
        backtrack(digits, index + 1, new StringBuilder(combination).append((char) (startChar + 2)));
    }
}
