package problems.medium.math;


import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Problem: <a href="https://leetcode.com/problems/count-number-of-homogenous-substrings">
 * count-number-of-homogenous-substrings/</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1759 {
    public int countHomogenous(String s) {
        int res = 0;
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i - 1] == chars[i]) {
                count++;
            } else {
                count = 1;
            }
            res = (res + count) % 1000000007;
        }

        return res;
    }

    public int countHomogenous2(String s) {
        int modulo = 1_000_000_007;
        HashMap<String, Integer> substringCount = new HashMap<>();
        AtomicInteger res = new AtomicInteger();
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(pos) != s.charAt(i)) {
                String toAdd = s.substring(pos, i);
                substringCount.putIfAbsent(toAdd, 0);
                substringCount.put(toAdd, substringCount.get(toAdd) + 1);
                pos = i;
            }
        }
        String toAdd = s.substring(pos);
        substringCount.putIfAbsent(toAdd, 0);
        substringCount.put(toAdd, substringCount.get(toAdd) + 1);

        substringCount.forEach((substring, count) -> {
            int total = (substring.length() * (substring.length() + 1) / 2) * count;
            res.getAndUpdate(value -> (value + total) % 1000000007);
        });


        return res.get();
    }
}
