package problems.leetcode.medium.string;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/sequential-digits">
 * sequential-digits</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int minDigits = String.valueOf(low).length();
        int maxDigits = Math.min(String.valueOf(high).length(), 9);
        for (int i = minDigits; i <= maxDigits; i++) {
            StringBuilder sb = new StringBuilder();
            char toAdd;
            for (toAdd = '1'; toAdd < '1' + i; toAdd++) {
                sb.append(toAdd);
            }
            int possNum = Integer.parseInt(sb.toString());
            if (possNum >= low && possNum <= high) {
                res.add(possNum);
            }
            while (toAdd <= '9') {
                sb.deleteCharAt(0);
                sb.append(toAdd);
                possNum = Integer.parseInt(sb.toString());
                if (possNum >= low && possNum <= high) {
                    res.add(possNum);
                }
                toAdd++;
            }
        }

        return res;
    }
}
