package problems.leetcode.easy.array;


/**
 * Problem: <a href="https://leetcode.com/problems/minimum-common-value">
 * minimum-common-value</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        int pos = 0;
        for (int num : nums1) {
            while (pos < nums2.length && nums2[pos] < num) {
                pos++;
            }
            if (pos < nums2.length && num == nums2[pos]) {
                return num;
            }
        }
        return -1;
    }

    public int getCommon2(int[] nums1, int[] nums2) {
        int pos1 = 0;
        int pos2 = 0;
        while (pos1 < nums1.length && pos2 < nums2.length) {
            if (nums1[pos1] == nums2[pos2]) {
                return nums1[pos1];
            } else if (nums1[pos1] > nums2[pos2]) {
                pos2++;
            } else {
                pos1++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
