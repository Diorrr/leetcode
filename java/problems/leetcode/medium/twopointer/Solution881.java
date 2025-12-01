package problems.leetcode.medium.twopointer;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/boats-to-save-people">
 * boats-to-save-people</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution881 {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        int l = 0;
        int r = people.length - 1;
        Arrays.sort(people);
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                l++;
            }
            count++;
            r--;
        }

        return count;
    }
}
