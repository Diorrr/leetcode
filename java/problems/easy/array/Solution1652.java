package problems.easy.array;


/**
 * Problem: <a href="https://leetcode.com/problems/defuse-the-bomb">
 * defuse-the-bomb</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1652 {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0) {
            return res;
        } else if (k > 0) {
            int sum = 0;
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
            res[0] = sum;
            for (int i = 1; i < res.length; i++) {
                res[i] = res[i - 1] - code[i] + code[(i + k) % code.length];
            }
        } else {
            int sum = 0;
            for (int i = code.length + k; i < code.length; i++) {
                sum += code[i];
            }
            res[0] = sum;
            for (int i = 1; i < res.length; i++) {
                res[i] = res[i - 1] + code[i - 1] - code[(i + k + code.length - 1) % code.length];
            }
        }

        return res;
    }

    public int[] decrypt2(int[] code, int k) {
        int[] res = new int[code.length];

        if (k == 0) {
            return res;
        }

        int sum = 0;
        int start = k > 0 ? 1 : code.length + k;
        int end = k > 0 ? k : code.length - 1;

        for (int i = start; i <= end; i++) {
            sum += code[i % code.length];
        }

        // Compute result for each element
        for (int i = 0; i < code.length; i++) {
            res[i] = sum;
            sum += code[(end + 1) % code.length] - code[start % code.length];
            start++;
            end++;
        }

        return res;
    }
}
