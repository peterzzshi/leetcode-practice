package com.leetcode.removenthnodefromendoflist;

import com.leetcode.common.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(final ListNode head, final int n) {
        final ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}