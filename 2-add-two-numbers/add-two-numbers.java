
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1== null) return l2;
        if (l2== null) return l1;
       
        ListNode one = l1;
        ListNode two = l2;
        int carryNext = 0;
        int carryPrev = 0;

        while (one!=null && two!= null) {
            carryNext =  (one.val + two.val + carryPrev)/10;
            one.val = (one.val + two.val + carryPrev)%10;
            carryPrev = carryNext;


            if (one.next == null && two.next == null) break;

            if (one.next== null) one.next = new ListNode(0);
            if (two.next== null) two.next = new ListNode(0);

            one = one.next;
            two = two.next;
        }


        if(carryPrev!=0){
            one.next = new ListNode(1);
           
        }

        return l1;
    }
}