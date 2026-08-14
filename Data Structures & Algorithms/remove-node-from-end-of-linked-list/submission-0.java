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
        // Find length of linked list 
        int N = 0;
        ListNode dummy = new ListNode(0, head);
        ListNode head2 = dummy;
        while(head != null) {
            N += 1;
            head = head.next;
        }

        int skip = N-n;
        int i=0;
        while(i < skip) {
            head2 = head2.next;
            i+=1;
        }

        head2.next = head2.next.next;

        return dummy.next;

    }
}
