package problems.easy.string;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/number-of-senior-citizens">
 * number-of-senior-citizens</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2678 {
    public int countSeniors(String[] details) {
        int res = 0;
        for (String detail : details) {
            char tens = detail.charAt(11);
            char ones = detail.charAt(12);
            if (tens > '6' || (tens == '6' && ones >= '1')) {
                res++;
            }
        }

        return res;
    }

    public int countSeniors2(String[] details) {
        return (int) Arrays.stream(details)
                           .filter(detail -> detail.charAt(11) > '6' || (detail.charAt(11) == '6' && detail.charAt(12) >= '1'))
                           .count();
    }
}
