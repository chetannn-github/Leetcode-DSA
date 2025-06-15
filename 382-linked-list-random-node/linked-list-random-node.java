class Solution {
    ListNode head;
    int count;
    public Solution(ListNode head) {
        this.head = head;

        ListNode curr = head;
        this.count = 0;
        while(curr != null){
            this.count++;
            curr = curr.next;
        }
    }
    
    public int getRandom() {
        int rand = (int) (Math.random() * count);
        ListNode curr = head;
        while(rand-- > 0) {
            curr = curr.next;
        }
        return curr.val;
    }
}
