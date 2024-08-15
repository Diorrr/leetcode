package problems.easy.greedy;


/**
 * Problem: <a href="link">
 * problem</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        int count20 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                count5++;
            } else if (bill == 10) {
                count10++;
            } else {
                count20++;
            }
            bill -= 5;
            if (bill > 0) {
                if (bill >= 20) {
                    int return20 = Math.min(count20, bill / 20);
                    bill -= 20 * return20;
                    count20 -= return20;
                }
                if (bill >= 10) {
                    int return10 = Math.min(count10, bill / 10);
                    bill -= 10 * return10;
                    count10 -= return10;
                }
                if (bill >= 5) {
                    int return5 = Math.min(count5, bill / 5);
                    bill -= 5 * return5;
                    count5 -= return5;
                }
                if (bill > 0) {
                    return false;
                }
            }

        }
        return true;
    }
}
