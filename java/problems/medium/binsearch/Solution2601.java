package problems.medium.binsearch;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/prime-subtraction-operation">
 * prime-subtraction-operation</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2601 {
    public boolean primeSubOperation(int[] nums) {
        int[] primeNumber = new int[168];
        int pos = 0;
        boolean[] prime = new boolean[1001];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= 1000; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 1000; j += i) {
                    prime[j] = false;
                }
                primeNumber[pos++] = i;
            }
        }

        nums[0] -= binSearch(nums[0], primeNumber);

        for (int i = 1; i < nums.length; i++) {
            nums[i] -= binSearch(nums[i] - nums[i - 1], primeNumber);
            if (nums[i - 1] >= nums[i]) {
                return false;
            }
        }

        return true;
    }

    private int binSearch(int num, int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] < num && (m == arr.length - 1 || arr[m + 1] >= num)) {
                return arr[m];
            }
            if (arr[m] >= num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return 0;
    }
}
