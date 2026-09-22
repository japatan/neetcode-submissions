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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        
        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        int size = list.size();
        // get the index to remove the element at
        int target = size - n;

        if (target == 0) {
            return head.next;
        }

        ListNode prev = list.get(target - 1);
        // prev.next = list.get(target + 1);
        prev.next = list.get(target).next;
        return head;
    }
}
