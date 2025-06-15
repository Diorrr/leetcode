package problems.easy.bit;


/**
 * Problem: <a href="https://leetcode.com/problems/number-complement">
 * number-complement</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution476 {
    public int findComplement(int num) {
        int res = 0;
        int ind = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                res += 1 << ind;
            }
            num /= 2;
            ind++;
        }

        return res;
    }

    public int findComplement2(int num) {
        int res = 0;
        long toAdd = 1;
        while (toAdd <= num) {
            if ((num & toAdd) == 0) {
                res += toAdd;
            }
            toAdd *= 2;
        }

        return res;
    }
}
