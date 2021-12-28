package problems.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Problem: https://leetcode.com/problems/middle-of-the-linked-list/
 * Time Complexity: O(N)
 * Space Complexity： (N)
 */
class Solution876 {
    public class ListNode {
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

    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        ListNode next = head.next;
        while (next != null) {
            list.add(next);
            next = next.next;
        }

        return list.get(list.size() / 2);
    }

    public ListNode middleNode2(ListNode head) {
        int count;
        if (Objects.nonNull(head)) {
            count = 1;
        } else {
            return head;
        }
        ListNode next = head.next;
        while (Objects.nonNull(next)) {
            count++;
            next = next.next;
        }
        for (int i = 0; i < count / 2; i++) {
            head = head.next;
        }
        return head;
    }
}
