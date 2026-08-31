package com.leetcode.middleofthelinkedlist;

import com.leetcode.common.ListNode;

public class Solution {
    public ListNode middleNode(final ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}