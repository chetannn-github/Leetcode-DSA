class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;

        HashMap<Node,Node> hm = new HashMap<>();
        Node curr = head;
        Node ansHead = new Node(0);;
        Node ans = ansHead;

        ans.val = curr.val;
        hm.put(curr, ans);

        while(curr != null) {
            Node next = curr.next;

            if(curr.next != null) {
                int nextVal = curr.next.val;
                ans.next = new Node(nextVal);
                hm.put(curr.next, ans.next);
            }
        
            curr = curr.next;
            ans = ans.next;
        }

        curr = head;
        ans = ansHead;

        while (curr != null) {
            Node random = curr.random;
            if(random != null) ans.random = hm.get(random);

            curr = curr.next;
            ans = ans.next;
        }

        return ansHead;
    }
}