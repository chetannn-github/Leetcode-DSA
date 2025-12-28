class LRUCache {
    private HashMap<Integer, Node> map;
    private int size;
    private Node head, tail;
    int currSize = 0;

    public LRUCache(int size) {
       this.size = size;
       this.map = new HashMap<>();
       this.head = new Node(-1,-1);
       this.tail = new Node(-1,-1);
       head.prev = tail;
       tail.next = head;
    }

    public int get(int key) {
        Node curr = map.get(key);

        if(curr == null) return -1;

        removeNode(curr);
        addAtFirst(curr);
        map.put(key,curr);

        return curr.value;
    }

    public void put(int key, int value) {
        Node curr = map.get(key);
        if(curr == null) {
            currSize++;
            curr = new Node(key,value);
            addAtFirst(curr);
        }else {
            curr.value = value;
            removeNode(curr);
            addAtFirst(curr);
        }
        map.put(key,curr);
        if(currSize > size) {
            currSize = size;
            Node lru = tail.next;
            removeNode(lru);
            map.remove(lru.key);
        }
    }

    private void removeNode(Node curr) {
        if(curr.prev != null) curr.prev.next = curr.next;
        if(curr.next != null) curr.next.prev = curr.prev;
        curr.prev = null;
        curr.next = null;
    }

    private void addAtFirst(Node curr) {
        curr.prev = head.prev;
        head.prev.next = curr;

        head.prev = curr;
        curr.next = head;
    }

}

class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
