public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode curr = head;
        HashSet<ListNode> set = new HashSet<>();

        while (curr != null) {
            if(set.contains(curr)) return curr;
            set.add(curr);
            curr = curr.next;
        }

        return null;
    }
}



// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         if (head == null || head.next == null) return null;

//         ListNode slow = head;
//         ListNode fast = head;

//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;

//             if(slow == fast){
//                 break;
//             }
            
//         }

//         if(fast != slow) return null;
        
//         slow = head;
//         while(slow != fast) {
//             slow = slow.next;
//             fast = fast.next;
//         }
//         return slow;
//     }
// }