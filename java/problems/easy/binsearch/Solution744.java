package problems.easy.binsearch;

/**
 * Problem: <a href="https://leetcode.com/problems/find-smallest-letter-greater-than-target">
 * find-smallest-letter-greater-than-target</a>
 * Time Complexity: O(logN)
 * Space Complexity： O(1)
 */
class Solution744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (m > 0 && letters[m] > target && letters[m - 1] <= target) {
                return letters[m];
            }
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return letters[0];
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        for (char c : letters) {
            if (target < c) {
                return c;
            }
        }
        return letters[0];
    }
}
