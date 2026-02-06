class AllOne {
    private HashMap<String, Node> map;
    private Node head, tail;
    public AllOne() {
        this.map = new HashMap<>();
        this.head = new Node(-1);
        this.tail = new Node(0);
        head.prev = tail;
        tail.next = head;
    }
    
    public void inc(String key) {
        Node curr = map.getOrDefault(key,tail);
        int nextValue = curr.value + 1;
        curr.strings.remove(key);

        if(curr.next.value != nextValue) {
            Node newNode = new Node(nextValue);
            curr.addNode(newNode);
        }
            
        curr.next.strings.add(key);
        map.put(key,curr.next);
        if(curr != tail && curr.strings.isEmpty()) curr.removeNode();
        
    }
    
    public void dec(String key) {
        Node curr = map.get(key);
        int prevValue = curr.value - 1;
        curr.strings.remove(key);

        if(prevValue == 0 && curr.strings.size() == 0) {
            curr.removeNode();
            map.remove(key);
            return;
        }

        Node prev = curr.prev;

        if(prev.value != prevValue) {
            Node newNode = new Node(prevValue);
            prev.addNode(newNode);
        }

        curr.prev.strings.add(key);
        map.put(key,curr.prev);
        if(curr.strings.isEmpty()) curr.removeNode();
        
    }
    
    public String getMaxKey() {
        return head.prev == tail ? "" : head.prev.strings.iterator().next();

    }
    
    public String getMinKey() {
        return tail.next == head ? "" : tail.next.strings.iterator().next();
    }

    
}

class Node {
    Node prev, next;
    HashSet<String> strings;
    int value;

    Node(int value) {
        this.value = value;
        this.strings = new HashSet<>();
        this.prev = null;
        this.next = null;
    }

    public void removeNode() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
        this.prev = null;
        this.next = null;
    }

    public void addNode(Node newNode) {
        newNode.next = this.next;
        newNode.prev = this;
        this.next.prev = newNode;
        this.next = newNode;
    }

}

