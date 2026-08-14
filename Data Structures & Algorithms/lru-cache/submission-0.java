class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }
}

class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))  
            return -1;
        Node node =  map.get(key);
        // After get, since its recently accessed, put it at front:
        delete(node);
        insertAfterHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        // It already contains in map, so just change the value and put at first 
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            delete(node);
            insertAfterHead(node);
        }
        else { //doesnt contain in map 
            if(map.size() == capacity) { //since capacity is == size, remove the LRU node (tail->prev)
                Node lruNode = tail.prev;
                delete(lruNode);
                map.remove(lruNode.key);
            }
            // Add the node
            Node node = new Node(key, value);
            insertAfterHead(node);
            map.put(key, node);

        }
    }


    public void insertAfterHead(Node node) {
        Node currAfterHead = head.next;
        node.next = currAfterHead;
        node.prev = head;
        head.next = node;
        currAfterHead.prev = node;
    }

    public void delete(Node node) {
        Node prevNode = node.prev;
        Node afterNode = node.next;
        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }
}
