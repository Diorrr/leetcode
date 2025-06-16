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
    List<String> mapping = List.of(
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
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
        for (int i = 0; i < mapping.get(digit).length(); i++) {
            combination.append(mapping.get(digit).charAt(i));
            backtrack(digits, index + 1, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
