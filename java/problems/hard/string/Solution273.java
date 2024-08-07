package problems.hard.string;


/**
 * Problem: <a href="https://leetcode.com/problems/integer-to-english-words">
 * integer-to-english-words</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution273 {
    private String[] tensNames = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};

    private String[] numNames = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten",
            " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
    private String[] decs = {"", " Thousand", " Million", " Billion"};

    public String numberToWords(int num) {
        StringBuilder res = new StringBuilder();
        if (num == 0) {
            return "Zero";
        }
        for (String dec : decs) {
            if (num % 1000 != 0) {
                res.insert(0, convert1000(num % 1000, dec));
            }
            num /= 1000;
        }
        return res.toString().trim();
    }

    private StringBuilder convert1000(int num, String dec) {
        StringBuilder res = new StringBuilder();
        if (num / 100 > 0) {
            res.append(numNames[num / 100]).append(" Hundred");
        }
        num %= 100;
        if (num < 20) {
            res.append(numNames[num]);
        } else {
            res.append(tensNames[num / 10]);
            res.append(numNames[num % 10]);
        }

        res.append(dec);
        return res;
    }
}
