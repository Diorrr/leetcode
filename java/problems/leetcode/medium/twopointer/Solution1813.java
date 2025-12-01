package problems.leetcode.medium.twopointer;


/**
 * Problem: <a href="https://leetcode.com/problems/sentence-similarity-iii">
 * sentence-similarity-iii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        int start = 0;
        int end = 0;
        while (start < Math.min(arr1.length, arr2.length) && arr1[start].equals(arr2[start])) {
            start++;
        }
        while (start + end < Math.min(arr1.length, arr2.length) && arr1[arr1.length - 1 - end].equals(arr2[arr2.length - 1 - end])) {
            end++;
        }
        return start + end == arr1.length || start + end == arr2.length;
    }
}
