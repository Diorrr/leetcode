package problems.leetcode.medium.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/insert-delete-getrandom-o1">
 * insert-delete-getrandom-o1</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution380 {
    class RandomizedSet {
        Map<Integer, Integer> ind;
        List<Integer> nums;
        java.util.Random rand;

        public RandomizedSet() {
            ind = new HashMap<>();
            nums = new ArrayList<>();
            rand = new java.util.Random();
        }

        public boolean insert(int val) {
            if (ind.containsKey(val)) {
                return false;
            }
            ind.put(val, nums.size());
            nums.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!ind.containsKey(val)) {
                return false;
            }
            int pos = ind.get(val);
            if (pos < nums.size() - 1) {
                int lastAdded = nums.get(nums.size() - 1);
                nums.set(pos, lastAdded);
                ind.put(lastAdded, pos);
            }
            ind.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }

        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }
}
