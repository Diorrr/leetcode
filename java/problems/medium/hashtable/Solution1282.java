package problems.medium.hashtable;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to">
 * group-the-people-given-the-group-size-they-belong-to </a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> group = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            group.putIfAbsent(size, new ArrayList<>());
            group.get(size).add(i);
            if (group.get(size).size() == size) {
                res.add(group.get(size));
                group.put(size, new ArrayList<>());
            }
        }

        return res;
    }
}
