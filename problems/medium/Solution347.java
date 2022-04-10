package problems.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: https://leetcode.com/problems/top-k-frequent-elements/
 * Time Complexity:
 * Space Complexity：
 */
public class Solution347 {
    public int[] topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        List<Pair> pairList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        map.forEach((key, value) -> {
            pairList.add(new Pair(value, key));
        });

        return pairList.stream().sorted(Comparator.comparingInt(t -> t.first))
                .skip(pairList.size() - k)
                .map(Pair::getSecond)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private class Pair {
        Integer first;
        Integer second;

        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        public Integer getFirst() {
            return first;
        }

        public Integer getSecond() {
            return second;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer> list = map.values().stream().sorted().skip(map.values().size() - k).collect(Collectors.toList());
        map.forEach((key, v) -> {
            if (list.contains(v)) {
                res.add(key);
            }
        });

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
