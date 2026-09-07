package problems.leetcode.medium.linkedlist;

import problems.leetcode.util.ListNode;

/**
 * Problem: <a href="https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points">
 * find-the-minimum-and-maximum-number-of-nodes-between-critical-points</a>
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = new int[]{-1, -1};
        int posCurrent = 0;
        int posFirst = 0;
        Integer posPrev = null;
        int prevValue = head.val;
        head = head.next;
        while (head != null && head.next != null) {
            if ((prevValue < head.val && head.val > head.next.val) || (prevValue > head.val && head.val < head.next.val)) {
                if (posPrev == null) {
                    posFirst = posCurrent;
                } else {
                    res[0] = res[0] != -1 ? Math.min(posCurrent - posPrev, res[0]) : posCurrent - posPrev;
                    res[1] = posCurrent - posFirst;
                }
                posPrev = posCurrent;
            }
            prevValue = head.val;
            head = head.next;
            posCurrent++;
        }
        return res;
    }
}
