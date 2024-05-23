package problems.medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
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
        backtrack1(s, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(char[] chars, int index, LinkedList<String> linkedList) {
        if (index == chars.length) {
            res.add(new LinkedList<>(linkedList));
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = index; i < chars.length; i++) {
                sb.append(chars[i]);
                String substr = sb.toString();
                if (isPalindrome(substr)){
                    linkedList.add(substr);
                    backtrack(chars, i + 1, linkedList);
                    linkedList.removeLast();
                }
            }
        }
    }

    private void backtrack1(String original, int index, List<String> strings) {
        if (index == original.length()) {
            res.add(new ArrayList<>(strings));
        } else if (index < original.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = index; i < original.length(); i++) {
                sb.append(original.charAt(i));
                String substr = sb.toString();
                if (isPalindrome(substr)) {
                    strings.add(substr);
                    backtrack1(original, i + 1, strings);
                    strings.remove(strings.size()-1);
                }
            }
        }
    }

    public List<List<String>> partition2(String s) {
        backtrack(s.toCharArray(), 0, new LinkedList<>());
        return res;
    }

    private void backtrack3(String original, int index, List<String> strings) {
        if (index == original.length()) {
            res.add(new ArrayList<>(strings));
        } else if (index < original.length()) {
            for (int i = index + 1; i <= original.length(); i++) {
                String substr = original.substring(index, i);
                if (isPalindrome(substr)) {
                    strings.add(substr);
                    backtrack3(original, i, strings);
                    strings.remove(strings.size() - 1);
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
