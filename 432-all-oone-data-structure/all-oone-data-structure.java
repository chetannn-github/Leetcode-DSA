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
            Node newNode = new Node(nextValue,key);
            addNewNode(newNode,curr);
        }else {
            curr.next.strings.add(key);
        }
        map.put(key,curr.next);
        if(curr != tail && curr.strings.isEmpty()) removeNode(curr);
        
    }
    
    public void dec(String key) {
        Node curr = map.get(key);
        int prevValue = curr.value - 1;
        curr.strings.remove(key);

        if(prevValue == 0 && curr.strings.size() == 0) {
            removeNode(curr);
            map.remove(key);
            return;
        }

        Node prev = curr.prev;

        if(prev.value != prevValue) {
            Node newNode = new Node(prevValue,key);
            addNewNode(newNode,prev);
            map.put(key,newNode);
        }else {
            prev.strings.add(key);
            map.put(key,prev);
        }
        if(curr.strings.isEmpty()) removeNode(curr);
        
    }
    
    public String getMaxKey() {
        return head.prev == tail ? "" : head.prev.strings.iterator().next();

    }
    
    public String getMinKey() {
        return tail.next == head ? "" : tail.next.strings.iterator().next();
    }

    private void removeNode(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr.prev = null;
        curr.next = null;
    }

    private void addNewNode(Node newNode, Node curr) {
        newNode.next = curr.next;
        newNode.prev = curr;
        curr.next.prev = newNode;
        curr.next = newNode;
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

    Node(int value, String str) {
        this.value = value;
        this.strings = new HashSet<>();
        strings.add(str);
        this.prev = null;
        this.next = null;
    }

}

