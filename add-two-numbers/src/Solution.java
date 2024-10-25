public class Solution {
    public ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        final int sum = l1.val + l2.val;
        final ListNode result = new ListNode(sum % 10);
        result.next = this.addTwoNumbers(l1.next, l2.next);
        if (sum > 10) {
            result.next = this.addTwoNumbers(result.next, new ListNode(1));
        }
        return result;
    }
}