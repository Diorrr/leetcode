package problems.medium.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/bulb-switcher-ii">
 * bulb-switcher-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution672 {
    Set<String> res = new HashSet<>();

    public int flipLights(int n, int presses) {
        int[] bulbs = new int[n];
        Set<String> comb = new HashSet<>();
        comb.add("0".repeat(n));
        dfs(comb, presses);

        return res.size();
    }

    private void dfs(Set<String> comb, int n) {
        if (n == 0) {
            res.addAll(comb);
        } else {
            Set<String> newComb = new HashSet<>();
            comb.forEach(combination -> {
                newComb.add(manipulate(combination, 1));
                newComb.add(manipulate(combination, 2));
                newComb.add(manipulate(combination, 3));
                newComb.add(manipulate(combination, 4));
            });
            dfs(newComb, n - 1);
        }
    }

    private String manipulate(String combination, int code) {
        char[] copied = combination.toCharArray();
        if (code == 1) {
            for (int i = 0; i < copied.length; i++) {
                copied[i] = (char) ('1' - copied[i]);
            }
            return String.valueOf(copied);
        } else if (code == 2) {
            for (int i = 0; i < copied.length; i += 2) {
                copied[i] = (char) ('1' - copied[i]);
            }
            return String.valueOf(copied);

        } else if (code == 3) {
            for (int i = 1; i < copied.length; i += 2) {
                copied[i] = (char) ('1' - copied[i]);
            }
            return String.valueOf(copied);

        } else if (code == 4) {
            for (int i = 0; i < copied.length; i += 3) {
                copied[i] = (char) ('1' - copied[i]);
            }
            return String.valueOf(copied);
        }

        return null;
    }

    public static void main(String[] args) {
        new Solution672().flipLights(2, 1);
    }
}
