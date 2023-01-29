package problems.medium.pointer;

import util.ListNode;

import java.util.Objects;

/**
 * Problem: https://leetcode.com/problems/add-two-numbers/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int additional = 0;
        while (Objects.nonNull(l1) || Objects.nonNull(l2) || additional == 1) {
            int sum = 0;
            if (Objects.nonNull(l1)) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (Objects.nonNull(l2)) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += additional;
            ListNode node = new ListNode(sum % 10);
            additional = sum / 10;
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }
}
