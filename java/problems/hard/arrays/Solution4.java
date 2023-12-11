package problems.hard.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * Time Complexity:
 * Space Complexity：
 */
/**
 * Problem: <a href="https://leetcode.com/problems/median-of-two-sorted-arrays">
 * median-of-two-sorted-arrays</a>
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution4 {
    //solution from comments
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] merged = new int[n];
        int i = 0;
        int j = 0;
        int curr = 0;
        while (curr < n) {
            if (i < nums1.length && (j >= nums2.length || nums1[i] < nums2[j])) {
                merged[curr] = nums1[i];
                i++;
            } else {
                merged[curr] = nums2[j];
                j++;
            }
            curr++;
        }

        return n % 2 == 1 ? merged[n / 2]
                : (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int pos1 = 0, pos2 = 0;
        int med1 = 0, med2 = 0;
        int len1 = nums1.length, len2 = nums2.length;
        for (int i = 0; i <= (len1 + len2) / 2; i++) {
            med1 = med2;
            if (pos1 == len1) {
                med2 = nums2[pos2++];
            } else if (pos2 == len2) {
                med2 = nums1[pos1++];
            } else if (nums1[pos1] < nums2[pos2]) {
                med2 = nums1[pos1++];
            } else {
                med2 = nums2[pos2++];
            }
        }

        return (len1 + len2) % 2 == 0 ? (double) (med1 + med2) / 2 : med2;
    }

    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        List<Double> merged = Arrays.stream(nums1).mapToDouble(Double::valueOf).boxed().collect(Collectors.toList());
        merged.addAll(Arrays.stream(nums2).mapToDouble(Double::valueOf).boxed().toList());
        merged.sort(Double::compareTo);

        return merged.size() % 2 == 1 ? merged.get(merged.size() / 2) :
                (merged.get(merged.size() / 2 - 1) + merged.get(merged.size() / 2)) / 2;
    }
}
