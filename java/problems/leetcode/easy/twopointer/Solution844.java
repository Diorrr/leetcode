package problems.leetcode.easy.twopointer;

/**
 * Problem: https://leetcode.com/problems/backspace-string-compare
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        int sIndex = s.length() - 1, tIndex = t.length() - 1;

        while (sIndex >= 0 || tIndex >= 0) {
            if ((sIndex >= 0 && tIndex >= 0) && s.charAt(sIndex) != '#' && t.charAt(tIndex) != '#') {
                if (s.charAt(sIndex) != t.charAt(tIndex)) {
                    return false;
                } else {
                    sIndex--;
                    tIndex--;
                }
            } else {
                if (sIndex >= 0) {
                    if (s.charAt(sIndex) == '#') {
                        sIndex = getNextIndex(s, sIndex);
                    } else if (tIndex < 0) {
                        return false;
                    }
                }
                if (tIndex >= 0) {
                    if (t.charAt(tIndex) == '#') {
                        tIndex = getNextIndex(t, tIndex);
                    } else if (sIndex < 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public int getNextIndex(String input, int index) {
        int count = 1;
        for (int i = index - 1; i >= 0; i--) {
            if (count == 0) {
                return i;
            }
            if (input.charAt(i) == '#') {
                count++;
            } else {
                count--;
            }
        }

        return -1;
    }
}
