package problems.medium.prefixsum;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage">
 * minimum-amount-of-time-to-collect-garbage</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;
        char[] garbageTypes = new char[]{'M', 'P', 'G'};
        int[] pos = new int[3];
        int[] prefix = new int[travel.length + 1];
        for (int i = 0; i < travel.length; i++) {
            prefix[i + 1] = prefix[i] + travel[i];
        }
        int foundTypes = 0;
        for (int i = garbage.length - 1; i >= 0; i--) {
            res += garbage[i].length();
            if (foundTypes != 3) {
                for (char type : garbage[i].toCharArray()) {
                    for (int j = 0; j < garbageTypes.length; j++) {
                        if (type == garbageTypes[j]) {
                            if (pos[j] == 0) {
                                pos[j] = i;
                                res += prefix[i];
                                foundTypes++;
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    public int garbageCollection2(String[] garbage, int[] travel) {
        int res = 0;
        char[] garbageTypes = new char[]{'M', 'P', 'G'};

        int[] prefix = new int[travel.length + 1];
        for (int i = 0; i < travel.length; i++) {
            prefix[i + 1] = prefix[i] + travel[i];
        }
        for (char garbageType : garbageTypes) {
            res += countGarbageOccurrence(garbage, garbageType);
            res += prefix[lastGarbageOccurrence(garbage, garbageType)];
        }

        return res;
    }

    private int countGarbageOccurrence(String[] garbage, Character garbageType) {
        return Arrays.stream(garbage)
                     .mapToInt(gar -> Math.toIntExact(gar.chars()
                                                         .filter(ch -> ch == garbageType)
                                                         .count()))
                     .sum();

    }

    private int lastGarbageOccurrence(String[] garbage, Character garbageType) {
        for (int i = garbage.length - 1; i >= 0; i--) {
            if (garbage[i].chars().anyMatch(ch -> ch == garbageType)) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution2391().garbageCollection(
                        new String[]{"G", "P", "GP", "GG"},
                        new int[]{2, 4, 3}
                )
        );
    }
}
