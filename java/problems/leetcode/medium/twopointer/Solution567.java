package problems.leetcode.medium.twopointer;

/**
 * Problem: <a href="https://leetcode.com/problems/permutation-in-string">
 * permutation-in-string</a>
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int counter = 0, len1 = s1.length(), len2 = s2.length();
        int[] count1 = new int[256];
        int[] count2 = new int[256];
        char charAtLeft;
        char charAtRight;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        for (int i = 0; i < len1; i++) {
            count1[chars1[i]]++;
        }
        for (int i = 0; i < len2 && counter != len1; i++) {
            if (i >= len1) {
                charAtLeft = chars2[i - len1];
                if (count1[charAtLeft] < count2[charAtLeft]) {
                    counter++;
                } else {
                    counter--;
                }
                count2[charAtLeft]--;
            }
            charAtRight = chars2[i];
            if (count1[charAtRight] > count2[charAtRight]) {
                counter++;
            } else {
                counter--;
            }
            count2[charAtRight]++;
        }

        return counter == len1;
    }
}
