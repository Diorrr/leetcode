package problems.hard.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        HashMap<Integer, List<Integer>> count = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                count.putIfAbsent(num, new ArrayList<>());
                count.get(num).add(i);
            }
        }
        List<Integer> allNums = new ArrayList<>(count.keySet());
        allNums.sort(Integer::compareTo); // or use TreeMap to get sorted keySet
        int l = 0, r = 0;
        res.add(allNums.get(0));
        res.add(allNums.get(allNums.size() - 1));
        int[] filled = new int[nums.size()];

        while (l < allNums.size()) {
            while (r < allNums.size() && !isFilled(filled)) {
                count.get(allNums.get(r)).forEach(t -> filled[t]++);
                r++;
            }

            if (isFilled(filled) && allNums.get(r - 1) - allNums.get(l) < res.get(1) - res.get(0)) {
                res.set(0, allNums.get(l));
                res.set(1, allNums.get(r - 1));
            }

            count.get(allNums.get(l)).forEach(t -> filled[t]--);
            l++;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    boolean isFilled(int[] filled) {
        return Arrays.stream(filled).noneMatch(t -> t == 0);
    }
}
