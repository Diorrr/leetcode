package problems.medium.greedy;


/**
 * Problem: <a href="https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced">
 * minimum-number-of-swaps-to-make-the-string-balanced</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1963 {
    public int minSwaps(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c=='['){
                res++;
            } else {
                if (res > 0){
                    res--;
                }
            }
        }

        return (res + 1) / 2;
    }
}
