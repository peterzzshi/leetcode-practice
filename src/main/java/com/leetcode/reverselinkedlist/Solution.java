package com.leetcode.reverselinkedlist;

import com.leetcode.common.ListNode;

class Solution {
    public ListNode reverseList(final ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            final ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }
}

