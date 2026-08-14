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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        Stack<ListNode> stack = new Stack<>();

        // Push all lists into stack
        for (ListNode list : lists) {
            if (list != null) {
                stack.push(list);
            }
        }

        // Merge until one list remains
        while (stack.size() > 1) {
            ListNode l1 = stack.pop();
            ListNode l2 = stack.pop();

            ListNode merged = mergeTwoLists(l1, l2);
            stack.push(merged);
        }

        return stack.isEmpty() ? null : stack.pop();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
                
            } else {
                node.next = list2;
                list2 = list2.next;
                
            }
            node = node.next;
        }

        if(list1 != null) {
            node.next = list1;
        } 
        if(list2 != null) {
            node.next = list2;
        }

        return dummy.next;
    }

}
