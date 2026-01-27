// class Solution {
//     ListNode head;
//     int count;
//     public Solution(ListNode head) {
//         this.head = head;

//         ListNode curr = head;
//         this.count = 0;
//         while(curr != null){
//             this.count++;
//             curr = curr.next;
//         }
//     }
    
//     public int getRandom() {
//         int rand = (int) (Math.random() * count);
//         ListNode curr = head;
//         while(rand-- > 0) {
//             curr = curr.next;
//         }
//         return curr.val;
//     }
// }


class Solution {
    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int result = head.val;

        int count = 2;
        ListNode curr = head.next;

        while(curr != null) {
            int randomIdx = (int) Math.floor(Math.random() * count);
            count++;

            if(randomIdx == 0) result = curr.val;

            curr = curr.next;
        }

        return result;
    }
}

