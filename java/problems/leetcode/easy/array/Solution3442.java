package problems.leetcode.easy.array;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i">
 * maximum-difference-between-even-and-odd-frequency-i</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3442 {
    public int maxDifference(String s) {
        int maxOdd = 0;
        int maxEven = Integer.MAX_VALUE;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int countLetter : count) {
            if (countLetter % 2 == 0 && countLetter > 0) {
                maxEven = Math.min(countLetter, maxEven);
            } else {
                maxOdd = Math.max(countLetter, maxOdd);
            }
        }
        return maxOdd - (maxEven == Integer.MAX_VALUE ? 0 : maxEven);
    }
}
