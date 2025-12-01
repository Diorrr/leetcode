package problems.leetcode.medium.math;


import java.util.Scanner;

/**
 * Problem: <a href="https://leetcode.com/problems/fraction-addition-and-subtraction">
 * fraction-addition-and-subtraction</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution592 {
    public String fractionAddition(String expression) {
        Scanner s = new Scanner(expression).useDelimiter("/|(?=[-+])");
        int numerator = 0;
        int denominator = 1;
        while (s.hasNext()) {
            int a = s.nextInt();
            int b = s.nextInt();
            numerator = numerator * b + denominator * a;
            denominator = denominator * b;
            int g = gcd(numerator, denominator);
            numerator /= g;
            denominator /= g;
        }
        return numerator + "/" + denominator;
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        } else {
            return gcd(b, a % b);
        }
    }
}
