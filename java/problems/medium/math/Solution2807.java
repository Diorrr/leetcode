package problems.medium.math;


import util.ListNode;

/**
 * Problem: <a href="https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list">
 * insert-greatest-common-divisors-in-linked-list</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode res = new ListNode(0, head);
        while (head.next != null) {
            int val = gcd(head.val, head.next.val);
            head.next = new ListNode(val, head.next);
            head = head.next.next;
        }
        return res.next;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
