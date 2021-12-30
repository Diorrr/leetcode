package problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Time Complexity: O(N)
 * Space Complexity： O(1)
 */
class Solution19 {

    //Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        if (Objects.isNull(fast)) {
            return head.next;
        }

        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode cur = head;
        ListNode prev = null;
        int count;
        if (Objects.nonNull(head)) {
            count = 1;
        } else {
            return null;
        }

        while (Objects.nonNull(cur.next)) {
            count++;
            prev = cur;
            cur = cur.next;
        }
        if (count == n) {
            head = head.next;
        } else if (n == 1) {
            prev.next = null;
        } else {
            cur = head;
            for (int i = 0; i < count - n; i++) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = cur.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        if (Objects.isNull(head.next) && n == 1) {
            return null;
        }
        ListNode prev, curr, next;
        curr = head;
        List<ListNode> list = new ArrayList<>(List.of(curr));
        while (Objects.nonNull(curr.next)) {
            curr = curr.next;
            list.add(curr);
        }
        if (list.size() - n > 0 && n - 1 > 0) {
            prev = list.get(list.size() - n - 1);
            next = list.get(list.size() - n + 1);
            prev.next = next;
        } else if (list.size() - n > 0) {
            prev = list.get(list.size() - n - 1);
            prev.next = null;
        } else if (n - 1 > 0) {
            head = head.next;
        }

        return head;
    }
}
