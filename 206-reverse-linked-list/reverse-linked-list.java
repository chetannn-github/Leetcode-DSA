
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head== null ||head.next ==null){return head;}

        ListNode current = head;
        ListNode prev = null;
        ListNode right;
        
        while(current!= null){
            right = current.next;
            current.next = prev;
            prev = current;
            current = right; 
        }
        return prev;
    }
}