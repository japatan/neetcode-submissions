/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode dummyRes = res;

        ListNode copy1 = l1;
        ListNode copy2 = l2;

        int carry = 0;
        int total = carry;
        while (copy1 != null || copy2 != null || carry != 0) {
            // total = copy1.val + copy2.val;
            if (copy1 != null) {
                total += copy1.val;
                copy1 = copy1.next;
            }
            if (copy2 != null) {
                total += copy2.val;
                copy2 = copy2.next;
            }
            int tens = total / 10;
            int ones = total % 10;
            dummyRes.next = new ListNode(ones);
            dummyRes = dummyRes.next;
            carry = tens;
            total = carry;   // instead of total = 0
        };


        return res.next;
    }
}
