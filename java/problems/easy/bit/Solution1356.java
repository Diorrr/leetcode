package problems.easy.bit;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits">
 * sort-integers-by-the-number-of-1-bits</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1356 {
    public int[] sortByBits(int[] arr) {
        Integer[] integerArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArr, (a, b) -> {
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);
            return bitCountA == bitCountB ? a - b : bitCountA - bitCountB;
        });
        return Arrays.stream(integerArr).mapToInt(Integer::intValue).toArray();
    }
}
