package problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution17 {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (Objects.isNull(digits) || digits.length() == 0) {
            return res;
        }
        backtrack(digits, 0, "");
        return res;
    }

    private void backtrack(String digits, int index, String combination) {
        if (combination.length() == digits.length()) {
            res.add(combination);
        } else if (index < digits.length()) {
            int digit = digits.charAt(index) - '0';
            char startChar;
            if (digit < 7) {
                startChar = (char) ('a' + (digit - 2) * 3);
            } else if (digit == 7) {
                startChar = 'p';
                backtrack(digits, index + 1, combination + (char) (startChar + 3));
            } else if (digit == 8) {
                startChar = 't';
            } else {
                startChar = 'w';
                backtrack(digits, index + 1, combination + (char) (startChar + 3));
            }
            backtrack(digits, index + 1, combination + (char) (startChar));
            backtrack(digits, index + 1, combination + (char) (startChar + 1));
            backtrack(digits, index + 1, combination + (char) (startChar + 2));
        }
    }
}
