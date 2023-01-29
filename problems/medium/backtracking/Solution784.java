package problems.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/letter-case-permutation/
 * Time Complexity:
 * Space Complexity：
 */
class Solution784 {

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        res.add(s);
        backtrack(res, 0, s.toCharArray());

        return res;
    }

    private void backtrack(List<String> res, int index, char[] manipulate) {
        if (index < manipulate.length) {
            if (Character.isLetter(manipulate[index])) {
                backtrack(res, index + 1, manipulate);

                manipulate[index] = Character.isUpperCase(manipulate[index])
                        ? Character.toLowerCase(manipulate[index])
                        : Character.toUpperCase(manipulate[index]);

                res.add(new String(manipulate));
                backtrack(res, index + 1, manipulate);
            } else {
                backtrack(res, index + 1, manipulate);
            }
        }
    }

    public List<String> letterCasePermutation1(String s) {
        List<Integer> pos = new ArrayList<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                pos.add(i);
            }
        }
        int com = (int) Math.pow(2, pos.size());
        for (int i = 0; i < com; i++) {
            char[] manipulate = s.toCharArray();
            for (int j = 0; j < pos.size(); j++) {
                if ((i & (1L << j)) != 0) {
                    manipulate[pos.get(j)] = Character.isUpperCase(manipulate[pos.get(j)])
                            ? Character.toLowerCase(manipulate[pos.get(j)])
                            : Character.toUpperCase(manipulate[pos.get(j)]);
                }
            }
            res.add(new String(manipulate));
        }
        return res;
    }
}
