package problems.medium.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem: https://leetcode.com/problems/reverse-words-in-a-string/
 * Time Complexity:
 * Space Complexity：
 */
class Solution151 {
    public String reverseWords(String s) {
        List<String> splitList = Arrays.asList(s.trim().split(" +"));
        Collections.reverse(splitList);
        return String.join(" ", splitList);
    }

    public String reverseWords2(String s) {
        String[] split = s.split(" ");
        List<String> splitList = Arrays.asList(s.split(" ")).stream()
                .filter(t -> !t.isBlank())
                .collect(Collectors.toList());
        Collections.reverse(splitList);

        return splitList.stream().reduce("", (sum, elem) -> sum + " " + elem).substring(1);
    }
}
