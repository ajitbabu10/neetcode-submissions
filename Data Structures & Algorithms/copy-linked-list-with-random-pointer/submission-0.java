/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Create copies of original node to its copy 
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        Node curr = head;

        // iteration 1: create copies in hashmap
        while(curr != null) {
            Node value = new Node(curr.val);
            map.put(curr, value);
            curr = curr.next;
        }

        // iteration 2: Assign links 
        curr = head;
        while(curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
