package problems.medium.arrays;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/build-an-array-with-stack-operations">
 * build-an-array-with-stack-operations</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int curr = 1;
        for (int i = 0; i < target.length; i++) {
            while (curr < target[i]) {
                res.add("Push");
                res.add("Pop");
                curr++;
            }
            if (curr == target[i]) {
                res.add("Push");
                curr++;
            }
        }

        return res;
    }
}
