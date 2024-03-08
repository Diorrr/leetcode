package problems.easy.array;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/count-elements-with-maximum-frequency">
 * count-elements-with-maximum-frequency</a>
 * Time Complexity: O(N)
 * Space Complexity：O(N)
 */
class Solution3005 {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        int[] countOcc = new int[101];
        for (int num : nums) {
            count[num]++;
            countOcc[count[num]]++;
        }
        for (int i = 100; i >= 0; i--) {
            if (countOcc[i] > 0) {
                return countOcc[i] * i;
            }
        }
        return 1;
    }

    public int maxFrequencyElements2(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int maxOcc = Arrays.stream(count).max().getAsInt();
        return (int) (maxOcc * Arrays.stream(count).filter(countNum -> countNum == maxOcc).count());
    }
}
