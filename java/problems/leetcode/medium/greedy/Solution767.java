package problems.leetcode.medium.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/reorganize-string/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution767 {
    public String reorganizeString(String s) {
        char maxOccChar = 'a';
        int maxOcc = 0;
        int[] charCounter = new int[26];
        for (char i = 'a'; i <= 'z'; i++) {
            int count = count(i, s);
            charCounter[i - 'a'] = count;
            if (count > maxOcc) {
                maxOcc = count;
                maxOccChar = i;
            }
        }
        if ((s.length() + 1) / 2 < maxOcc) {
            return "";
        }
        char[] res = new char[s.length()];
        int index = 0;
        for (int i = 0; i < maxOcc; i++) {
            res[i * 2] = maxOccChar;
            index = i * 2 + 2;
            charCounter[maxOccChar - 'a']--;
        }
        for (char c : s.toCharArray()) {
            while (charCounter[c - 'a'] != 0) {
                index = index < s.length() ? index : 1;
                res[index] = c;
                index += 2;
                charCounter[c - 'a']--;
            }
        }

        return String.valueOf(res);
    }

    public String reorganizeString2(String s) {
        List<int[]> list = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            int count = count(i, s);
            if (count != 0) {
                list.add(new int[]{count, i});
            }
        }
        list.sort((a, b) -> b[0] - a[0]);
        if ((s.length() + 1) / 2 < list.get(0)[0]) {
            return "";
        }
        List<StringBuilder> res = new ArrayList<>();
        for (int i = 0; i < list.get(0)[0]; i++) {
            res.add(new StringBuilder(String.valueOf((char) list.get(0)[1])));
        }
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            char toAdd = (char) list.get(i)[1];
            for (int j = 0; j < list.get(i)[0]; j++) {
                res.get(index).append(toAdd);
                index = (index + 1) % res.size();
            }
        }

        return res.stream().reduce(new StringBuilder(""), (a, b) -> a.append(b.toString())).toString();
    }

    private int count(char charToCount, String s) {
        return s.chars().filter(c -> c == charToCount).toArray().length;
    }
}
