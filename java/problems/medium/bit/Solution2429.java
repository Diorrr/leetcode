package problems.medium.bit;


/**
 * Problem: <a href="https://leetcode.com/problems/minimize-xor">
 * minimize-xor</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2429 {
    public int minimizeXor(int num1, int num2) {
        int currCount = Integer.bitCount(num1);
        int count = Integer.bitCount(num2);
        int pos = 0;
        while (count != currCount) {
            if ((num1 & (1 << pos)) != 0 && count < currCount) {
                currCount--;
                num1 -= 1 << pos;
            }
            if ((num1 & (1 << pos)) == 0 && count > currCount) {
                currCount++;
                num1 += 1 << pos;
            }
            pos++;
        }

        return num1;
    }

    public int minimizeXor2(int num1, int num2) {
        int res = num1;
        int currCount = Integer.bitCount(res);
        char[] binRes = Integer.toBinaryString(res).toCharArray();
        int count = Integer.bitCount(num2);
        if (count > currCount) {
            for (int i = binRes.length - 1; i >= 0 && count > currCount; i--) {
                if (binRes[i] == '0') {
                    currCount++;
                    binRes[i] = '1';
                }
            }
            return Integer.valueOf("1".repeat(count - currCount) + new String(binRes), 2);
        }
        for (int i = binRes.length - 1; i >= 0 && count < currCount; i--) {
            if (binRes[i] == '1') {
                currCount--;
                binRes[i] = '0';
            }
        }

        return Integer.valueOf(new String(binRes), 2);
    }
}
