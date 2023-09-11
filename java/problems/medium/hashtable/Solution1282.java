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
            group.putIfAbsent(groupSizes[i], new ArrayList<>());
            group.get(groupSizes[i]).add(i);
            if (group.get(groupSizes[i]).size() == groupSizes[i]) {
                res.add(group.get(groupSizes[i]));
                group.put(groupSizes[i], new ArrayList<>());
            }
        }

        return res;
    }
}
