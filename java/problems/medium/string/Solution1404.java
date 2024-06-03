package problems.medium.string;


import java.util.LinkedList;

/**
 * Problem: <a href="https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one">
 * number-of-steps-to-reduce-a-number-in-binary-representation-to-one</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1404 {
    public int numSteps(String s) {
        int res = 0;
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        while (list.size() != 1) {
            if (list.getLast() == '0') {
                list.removeLast();
            } else {
                boolean toAdd = true;
                for (int i = list.size() - 1; i >= 0 && toAdd; i--) {
                    if (list.get(i) == '0') {
                        list.set(i, '1');
                        toAdd = false;
                    } else {
                        list.set(i, '0');
                    }
                }
                if (toAdd) {
                    list.addFirst('1');
                }
            }
            res++;
        }
        return res;
    }
}
