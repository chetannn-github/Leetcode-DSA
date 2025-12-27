class LRUCache {
    private HashMap<Integer, Node> map;
    private int size;
    private Node head, tail;
    int currSize = 0;
    Node curr;

    public LRUCache(int size) {
       this.size = size;
       this.map = new HashMap<>();
       this.head = new Node(-1,-1);
       this.tail = new Node(-1,-1);
       head.prev = tail;
       tail.next = head;
    }

    public int get(int key) {
        curr = map.get(key);

        if(curr == null) return -1;

        removeNode();
        addAtFirst();
        map.put(key,curr);

        return curr.value;
    }

    public void put(int key, int value) {
        curr = map.get(key);
        if(curr == null) {
            currSize++;
            curr = new Node(key,value);
            addAtFirst();
        }else {
            curr.value = value;
            removeNode();
            addAtFirst();
        }
        map.put(key,curr);
        if(currSize > size) {
            currSize = size;
            curr = tail.next;
            removeNode();
            map.remove(curr.key);
        }
    }

    private void removeNode() {
        if(curr.prev != null) curr.prev.next = curr.next;
        if(curr.next != null) curr.next.prev = curr.prev;
        curr.prev = null;
        curr.next = null;
    }

    private void addAtFirst() {
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
