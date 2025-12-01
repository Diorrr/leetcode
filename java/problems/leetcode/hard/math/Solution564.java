package problems.leetcode.hard.math;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/find-the-closest-palindrome">
 * find-the-closest-palindrome</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution564 {
    public String nearestPalindromic(String n) {
        List<Long> candidates = new ArrayList<>();
        int mid = (n.length() + 1) / 2;
        long left = Long.parseLong(n.substring(0, mid));
        long diff = Long.MAX_VALUE, res = 0;
        long number = Long.parseLong(n);
        candidates.add(fullPalindrome(left, n.length()));
        candidates.add(fullPalindrome(left - 1, n.length()));
        candidates.add(fullPalindrome(left + 1, n.length()));
        candidates.add((long) Math.pow(10, n.length() - 1) - 1);
        candidates.add((long) Math.pow(10, n.length()) + 1);


        for (Long candidate : candidates) {
            if (candidate != number) {
                if (Math.abs(candidate - number) < diff) {
                    diff = Math.abs(candidate - number);
                    res = candidate;
                } else if (Math.abs(candidate - number) == diff) {
                    res = Math.min(candidate, res);
                }
            }
        }

        return String.valueOf(res);
    }

    private long fullPalindrome(long left, int length) {
        long res = left;
        if (length % 2 != 0) {
            left /= 10;
        }
        while (left > 0) {
            res = res * 10 + left % 10;
            left /= 10;
        }

        return res;
    }
}
