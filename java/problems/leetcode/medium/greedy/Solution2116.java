package problems.leetcode.medium.greedy;


/**
 * Problem: <a href="https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid">
 * check-if-a-parentheses-string-can-be-valid</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2116 {
    public boolean canBeValid(String s, String locked) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            balance += s.charAt(i) == '(' || locked.charAt(i) == '0' ? 1 : -1;
            if (balance < 0) {
                return false;

            }
        }
        balance = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            balance += s.charAt(i) == ')' || locked.charAt(i) == '0' ? 1 : -1;
            if (balance < 0) {
                return false;

            }
        }

        return s.length() % 2 == 0;
    }
}
