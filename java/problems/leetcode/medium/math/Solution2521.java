package problems.leetcode.medium.math;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: <a href="link">
 * problem</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2521 {
    public int distinctPrimeFactors(int[] nums) {
        int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        Set<Integer> primeFactors = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (Integer primeNumber : prime) {
                if (nums[i] % primeNumber == 0) {
                    while (nums[i] % primeNumber == 0) {
                        nums[i] /= primeNumber;
                    }
                    primeFactors.add(primeNumber);
                }
            }
            if (nums[i] != 1) {
                primeFactors.add(nums[i]);
            }
        }

        return primeFactors.size();
    }

    public int distinctPrimeFactors2(int[] nums) {
        List<Integer> primeNumbers = getPrimeNumbers();
        Set<Integer> primeFactors = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (Integer primeNumber : primeNumbers) {
                while (nums[i] % primeNumber == 0) {
                    primeFactors.add(primeNumber);
                    nums[i] /= primeNumber;
                }
            }
        }

        return primeFactors.size();
    }

    private List<Integer> getPrimeNumbers() {
        List<Integer> primeNumber = new ArrayList<>();
        boolean[] prime = new boolean[1001];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= 1000; i++) {
            if (prime[i]) {
                if (i * i <= 1000) {
                    for (int j = i * i; j <= 1000; j += i) {
                        prime[j] = false;
                    }
                }
            }
            if (prime[i]) {
                primeNumber.add(i);
            }
        }

        return primeNumber;
    }

    private List<Integer> getPrimeNumbers2() {
        List<Integer> primeNumber = new ArrayList<>();
        for (int i = 2; i <= 1000; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumber.add(i);
            }
        }

        return primeNumber;
    }
}
