package problems.easy.string;

/**
 * Problem: <a href="https://leetcode.com/problems/ransom-note">
 * ransom-note</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) {
                return false;
            }
            count[c - 'a']--;
        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : ransomNote.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] > count2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int toAdd = ransomNote.length();
        int[] count = new int[26];
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            if (count[c - 'a'] > 0) {
                count[c - 'a']--;
                toAdd--;
            }
        }
        return toAdd == 0;
    }
}
