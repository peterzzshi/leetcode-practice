package com.leetcode.reorderlist;

import com.leetcode.common.ListNode;

public class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = this.reverseList(slow.next);
        slow.next = null;

        while (mid != null) {
            final ListNode node1 = head.next;
            final ListNode node2 = mid.next;

            head.next = mid;
            mid.next = node1;
            head = node1;
            mid = node2;
        }
    }

    ListNode reverseList(final ListNode head) {
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