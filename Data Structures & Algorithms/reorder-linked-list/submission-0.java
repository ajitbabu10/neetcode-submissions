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
    public void reorderList(ListNode head) {
        /*  1. Find the middle
            2. Reverse the 2nd half
            3. Merge 1st and 2nd half one by one
        */

        // 1. find Middle 

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        // 2. Reverse 2nd half
        ListNode second = slow.next;
        slow.next = null; // bReak the list
        ListNode prev = null;

        while(second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        // 3. Merge
        ListNode first = head;
        second = prev; // since second actually becomes null while reversing and the actual last one is prev 

        while(second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }
}
