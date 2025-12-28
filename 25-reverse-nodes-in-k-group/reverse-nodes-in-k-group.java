class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int totalNodes = countNodes(head);
        int reverseCount = totalNodes / k;
        int currRevCount = 0;
        ListNode newHead = head;

        int count = 1;
        ListNode start = head;
        ListNode startPrev = null;
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null && currRevCount != reverseCount) {
            ListNode next = curr.next;
            if(prev != null) curr.next = prev;

            prev = curr;
            curr = next;
            
            if(count == k) {
                if(startPrev != null) startPrev.next = prev;
                start.next = curr;
                startPrev = start;
                start = curr;
                
               
                count = 0;
                currRevCount++;

                if(currRevCount == 1) {
                    newHead = prev;
                } 
                prev = null;
            }

            count++;
        }

        return newHead;
    }

    private int countNodes(ListNode curr) {
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}