package problems.medium.sorting;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/top-k-frequent-elements/
 * Time Complexity:
 * Space Complexity：
 */
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        freq.keySet().forEach(key -> {
            if (bucket[freq.get(key)] == null) {
                bucket[freq.get(key)] = new ArrayList<>();
            }
            bucket[freq.get(key)].add(key);
        });

        for (int i = bucket.length - 1; i >= 0 && k > 0; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] topKFrequent2(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        while (k > 0) {
            k--;
            res[k] = queue.poll()[0];
        }

        return res;
    }

    public int[] topKFrequent3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> count = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count.add(new int[]{entry.getKey(), entry.getValue()});
        }
        count.sort(Comparator.comparingInt(a -> a[1]));

        return count.stream().skip(count.size() - k).map(t -> t[0]).mapToInt(Integer::intValue).toArray();
    }
}
