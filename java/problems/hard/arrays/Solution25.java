package problems.hard.arrays;


import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/reverse-nodes-in-k-group">
 * reverse-nodes-in-k-group</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode[] arr = list.toArray(new ListNode[0]);
        for (int i = 0; i + k <= arr.length; i += k) {
            int left = i;
            int right = i + k - 1;
            while (left < right) {
                var temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            if (i > 0) {
                arr[i - 1].next = arr[i];
            }
            for (int j = i; j < i + k - 1; j++) {
                arr[j].next = arr[j + 1];
            }
            if (i + k == arr.length) {
                arr[arr.length - 1].next = null;
            } else {
                arr[i + k - 1].next = arr[i + k];
            }
        }

        return arr[0];
    }
}
