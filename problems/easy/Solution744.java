package problems.easy;

/**
 * Problem: https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * Time Complexity: O(logN)
 * Space Complexity： O(1)
 */
class Solution744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int l = -1, r = letters.length, m;
        while (l < r - 1) {
            m = (l + r) / 2;
            if (letters[m] <= target) {
                l = m;
            } else {
                r = m;
            }
        }

        return r == letters.length ? letters[0] : letters[r];
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
