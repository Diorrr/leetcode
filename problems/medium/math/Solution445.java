package problems.medium.math;

import util.ListNode;

import java.math.BigInteger;

/**
 * Problem: <a href="https://leetcode.com/problems/add-two-numbers-ii">
 * add-two-numbers-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }
        String sum = new BigInteger(sb1.toString()).add(new BigInteger(sb2.toString())).toString();
        ListNode res = new ListNode();
        ListNode prev = new ListNode();
        res.next = prev;

        for (char number : sum.toCharArray()) {
            ListNode curr = new ListNode();
            curr.val = number - '0';
            prev.next = curr;
            prev = curr;
        }


        return res.next.next;
    }
}
