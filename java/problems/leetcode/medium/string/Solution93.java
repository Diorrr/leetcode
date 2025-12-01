package problems.leetcode.medium.string;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/restore-ip-addresses">
 * restore-ip-addresses</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        solve(res, 1, String.valueOf(s.charAt(0)), "", 0, s);
        return res;
    }

    private void solve(List<String> res, int index, String currNumber, String currRes, int count, String s) {
        if (count == 4) {
            if (currRes.length() - 4 == s.length()) {
                res.add(currRes.substring(1));
            }
            return;
        }

        if (isValid(currNumber)) {
            if (index < s.length()) {
                solve(res, index + 1, String.valueOf(s.charAt(index)), currRes + "." + currNumber, count + 1, s);
                currNumber += s.charAt(index);
                solve(res, index + 1, currNumber, currRes, count, s);
            } else {
                solve(res, index + 1, "", currRes + "." + currNumber, count + 1, s);
            }
        }
    }

    private boolean isValid(String curr) {
        return !curr.equals("") && Integer.parseInt(curr) < 256
                && (curr.equals("0") || !curr.startsWith("0"));
    }
}
