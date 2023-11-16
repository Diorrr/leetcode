package problems.medium.arrays;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/find-unique-binary-string">
 * find-unique-binary-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1980 {
    public String findDifferentBinaryString(String[] nums) {
        boolean[] used = new boolean[1 << nums.length];
        for (String num : nums) {
            used[Integer.parseInt(num, 2)] = true;
        }

        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                return toBinary(i, nums.length);
            }
        }

        return "";
    }

    public String findDifferentBinaryString2(String[] nums) {
        String binary = "";
        for (int i = 0; i < 1 << nums.length; i++) {
            binary = toBinary(i, nums.length);
            String finalBinary = binary;
            boolean isFound = Arrays.stream(nums)
                                    .filter(num -> num.equals(finalBinary))
                                    .findAny()
                                    .isEmpty();
            if (isFound) {
                break;
            }
        }

        return binary;
    }

    private String toBinary(int num, int length) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < length; j++) {
            sb.append((num & (1L << j)) != 0 ? "1" : "0");
        }

        while (sb.length() < length) {
            sb.append("0");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution1980().findDifferentBinaryString(new String[]{
                        "01", "10"
                })
        );
    }
}
