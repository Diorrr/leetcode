package problems.leetcode.medium.greedy;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/construct-k-palindrome-strings">
 * construct-k-palindrome-strings</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1400 {
    public boolean canConstruct(String s, int k) {
        int[] count = new int[26];
        int total = s.length();
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int occ : count) {
            if (occ % 2 == 1) {
                if (k < 1) {
                    return false;
                }
                k--;
                total--;
            }
        }

        return k == 0 || (k > 0 && total >= k);
    }

    public boolean canConstruct2(String s, int k) {
        int[] count = new int[26];
        Queue<Integer> odd = new LinkedList<>();
        Queue<Integer> even = new LinkedList<>();
        int total = s.length();
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (count[i] % 2 == 1) {
                    odd.add(i);
                } else {
                    even.add(i);
                }
            }
        }

        while (k > 0) {
            if (k == total) {
                return true;
            }
            if (!odd.isEmpty()) {
                k--;
                total--;
                if (count[odd.peek()] > 2) {
                    even.add(odd.peek());
                }
                count[odd.poll()]--;
            } else if (!even.isEmpty()) {
                if (total >= k) {
                    return true;
                } else {
                    return false;
                }
            } else {
                break;
            }
        }
        return k == 0 && odd.isEmpty();
    }

}
