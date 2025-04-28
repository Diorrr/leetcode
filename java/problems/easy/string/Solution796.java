package problems.easy.string;

/**
 * Problem: <a href="https://leetcode.com/problems/rotate-string">
 * rotate-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution796 {
    public boolean rotateString(String s, String goal) {
        char[] sChars = s.toCharArray();
        char[] goalChars = goal.toCharArray();
        if (sChars.length != goalChars.length) {
            return false;
        }
        for (int i = 0; i < sChars.length; i++) {
            if (isEqualAfterRotate(sChars, goalChars, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEqualAfterRotate(char[] sChars, char[] goalChars, int start) {
        int sInd = start;
        int goalInd = 0;
        for (; sInd < sChars.length; sInd++, goalInd++) {
            if (sChars[sInd] != goalChars[goalInd]) {
                return false;
            }
        }
        sInd=0;
        for (; sInd < start; sInd++, goalInd++) {
            if (sChars[sInd] != goalChars[goalInd]) {
                return false;
            }
        }
        return true;
    }

    public boolean rotateString2(String s, String goal) {
        char[] sChars = s.toCharArray();
        char[] goalChars = goal.toCharArray();
        if (sChars.length != goalChars.length) {
            return false;
        }
        for (int i = 0; i < sChars.length; i++) {
            if (isEqualAfterRotate2(sChars, goalChars, i, i, 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEqualAfterRotate2(char[] sChars, char[] goalChars, int start, int curr, int goalInd) {
        if (sChars[curr] != goalChars[goalInd]) {
            return false;
        }
        curr = (curr + 1) % sChars.length;
        if (curr == start) {
            return true;
        }
        return isEqualAfterRotate2(sChars, goalChars, start, curr, (goalInd + 1) % goalChars.length);
    }
}
