package problems.easy.string;


/**
 * Problem: <a href="https://leetcode.com/problems/count-prefix-and-suffix-pairs-i">
 * count-prefix-and-suffix-pairs-i</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3042 {
    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    res++;
                }
            }
        }

        return res;
    }
}
