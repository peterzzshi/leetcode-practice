package com.leetcode.mergetwosortedlists;

import com.leetcode.common.ListNode;

public class Solution {
    public ListNode mergeTwoLists(final ListNode list1, final ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        final ListNode result;
        if (list1.val < list2.val) {
            result = new ListNode(list1.val);
            result.next = this.mergeTwoLists(list1.next, list2);
        } else {
            result = new ListNode(list2.val);
            result.next = this.mergeTwoLists(list1, list2.next);
        }
        return result;
    }
}