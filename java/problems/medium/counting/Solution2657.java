package problems.medium.counting;


/**
 * Problem: <a href="https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays">
 * find-the-prefix-common-array-of-two-arrays</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];
        int[] countA = new int[A.length + 1];
        int[] countB = new int[A.length + 1];
        countA[A[0]]++;
        countB[B[0]]++;
        if (A[0] == B[0]) {
            res[0] = 1;
        }
        for (int i = 1; i < A.length; i++) {
            countA[A[i]]++;
            countB[B[i]]++;
            res[i] += res[i - 1];
            if (A[i] == B[i]) {
                res[i]++;
            } else {
                if (countA[A[i]] <= countB[A[i]]) {
                    res[i]++;
                }
                if (countB[B[i]] <= countA[B[i]]) {
                    res[i]++;
                }
            }
        }

        return res;
    }
}
