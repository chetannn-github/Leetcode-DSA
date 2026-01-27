class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;

        HashMap<Node,Node> map = new HashMap<>();
        Node curr = head;
    
        while(curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        System.out.println(map.toString());

        Node resultHead = map.get(head);
        curr = head;
        Node copy = resultHead;

        while (curr != null) {
            Node random = curr.random;
            Node next = curr.next;

            if(random != null) copy.random = map.get(random);
            if(next != null) copy.next = map.get(next);

            curr = curr.next;
            copy = copy.next;
            
        }

        return resultHead;
    }
}