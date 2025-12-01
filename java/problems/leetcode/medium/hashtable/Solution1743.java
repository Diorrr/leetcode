package problems.leetcode.medium.hashtable;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/restore-the-array-from-adjacent-pairs">
 * restore-the-array-from-adjacent-pairs</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        Map<Integer, List<Integer>> edges = new HashMap<>();

        for (int[] adjacentPair : adjacentPairs) {
            edges.putIfAbsent(adjacentPair[0], new ArrayList<>());
            edges.putIfAbsent(adjacentPair[1], new ArrayList<>());
            edges.get(adjacentPair[0]).add(adjacentPair[1]);
            edges.get(adjacentPair[1]).add(adjacentPair[0]);
        }

        edges.forEach((key, value) -> {
            if (value.size() == 1 && !used.contains(key)) {
                res.add(key);
                used.add(key);
                int prev = key;
                int curr = edges.get(key).get(0);
                while (edges.get(curr) != null && edges.get(curr).size() == 2) {
                    res.add(curr);
                    used.add(curr);
                    curr = edges.get(curr).get(0) != prev ?
                            edges.get(curr).get(0) : edges.get(curr).get(1);
                    prev = res.get(res.size() - 1);
                }
                res.add(curr);
                used.add(curr);
            }
        });

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
