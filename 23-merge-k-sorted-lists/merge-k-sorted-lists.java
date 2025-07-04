class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val - b.val));

        for(ListNode node : lists) if(node!= null) pq.add(node);

        ListNode mainNode = new ListNode(-1);
        ListNode dummy = mainNode;

        while(!pq.isEmpty()) {
            ListNode curr = pq.remove();
            dummy.next = curr;
            dummy = dummy.next;
        
            if(curr.next != null) {
                curr = curr.next;
                pq.add(curr);
            }

            dummy.next = null;
        }

        return mainNode.next;


    }
}