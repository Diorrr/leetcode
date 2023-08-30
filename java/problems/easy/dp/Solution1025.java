package problems.easy.dp;

/**
 * Problem: <a href="https://leetcode.com/problems/divisor-game/description/">
 * divisor-game</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1025 {

    public boolean divisorGame(int n) {
        if (n == 1) {
            return false;
        }
        int[] calc = new int[n + 1];
        calc[1] = 0;
        calc[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && calc[i - j] == 0) {
                    calc[i] = 1;
                }
            }
        }
        return calc[n] > 0;
    }

    /*
        if player has even number, it turned it to even/odd
        but if player has odd number, it turned only to even number.
        player who gets 2 will win, so player with even number initially wins the game;
     */
    public boolean divisorGame2(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {

    }
}
