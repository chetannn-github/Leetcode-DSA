class TextEditor {
    Node head,curr;
    
    public TextEditor() {
        head = new Node('A');
        curr = head;
    }
    
    public void addText(String text) {
        for(char ch : text.toCharArray()) {
            addNewNode(ch);
        } 
    }
    
    public int deleteText(int k) {
        int deletionCount = 0;
        while(k-->0 && curr != head) {
            removeNode();
            deletionCount++;
        }   

        return deletionCount;
    }
    
    public String cursorLeft(int k) {
        while(k-->0 && curr != head) curr = curr.prev;
        return getPreviousString();
    }
    
    public String cursorRight(int k) {
        while(k--> 0 && curr.next != null) curr = curr.next;
        return getPreviousString();
    }

    private void addNewNode(char ch) {
        Node node = new Node(ch);
        node.next = curr.next;
        if(curr.next != null) curr.next.prev = node;
        node.prev = curr;
        curr.next = node;
        
        curr = node;
    }

    private void removeNode() {
        Node prev = curr.prev;
        Node next = curr.next;

        curr.prev = null;
        curr.next = null;

        prev.next = next;

        if(next != null) next.prev = prev;

        curr = prev;
    }

    private String getPreviousString() {
        Node node = curr;
        int length = 0;
        StringBuilder result = new StringBuilder();

        while(node != head && length < 10) {
            result.append(node.value);
            node = node.prev;
            length++;
        }

        return result.reverse().toString();
    }
}


class Node{
    Node prev, next;
    char value;
    Node(char value) {
        this.prev = null;
        this.next = null;
        this.value = value;
    }
}