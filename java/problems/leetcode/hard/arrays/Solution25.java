package problems.leetcode.hard.arrays;


import problems.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/reverse-nodes-in-k-group">
 * reverse-nodes-in-k-group</a>
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        for (int i = 0; i + k <= list.size(); i += k) {
            int left = i;
            int right = i + k - 1;
            while (left < right) {
                var temp = list.get(left).val;
                list.get(left).val = list.get(right).val;
                list.get(right).val = temp;
                left++;
                right--;
            }
        }

        return list.get(0);
    }
}
