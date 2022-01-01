package problems.medium;

/**
 * Problem: https://leetcode.com/problems/permutation-in-string/
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int counter = 0, len1 = s1.length(), len2 = s2.length();
        int[] set1 = new int[256];
        int[] set2 = new int[256];
        char charAtLeft, charAtRight;
        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();

        for (int i = 0; i < len1; i++) {
            set1[chars1[i]]++;
        }
        for (int i = 0; i < len2; i++) {
            if (i >= len1) {
                charAtLeft = chars2[i - len1];
                if (set1[charAtLeft] >= set2[charAtLeft]) {
                    counter--;
                } else {
                    counter++;
                }
                set2[charAtLeft]--;
            }
            charAtRight = chars2[i];
            if (set1[charAtRight] > set2[charAtRight]) {
                counter++;
            } else {
                counter--;
            }
            set2[charAtRight]++;

            if (i + 1 >= len1 && counter == len1) {
                return true;
            }
        }

        return counter == len1;
    }
}
