package problems.medium.arrays;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="link">
 * problem</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = l[i]; j <= r[i]; j++) {
                list.add(nums[j]);
            }
            boolean isArif = true;
            if (list.size() > 1) {
                list.sort(Integer::compareTo);
                int diff = list.get(1) - list.get(0);
                for (int j = 2; j < list.size(); j++) {
                    if (list.get(j) - list.get(j - 1) != diff) {
                        isArif = false;
                        break;
                    }
                }
            }
            res.add(isArif);
        }

        return res;
    }
}
