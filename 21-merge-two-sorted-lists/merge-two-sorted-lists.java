class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null ) return list1;
        ListNode pointer;
        ListNode ans;
        
        if(list1.val >= list2.val) {
            pointer = list2;
            list2 = list2.next;
        }else {
            pointer = list1;
            list1 = list1.next;
        }

        ans = pointer;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                pointer.next = list2;
                break;
            }else if (list2 == null) {
                pointer.next = list1;
                break;
            }else if (list1.val >= list2.val) {
                pointer.next = list2;
                pointer = pointer.next;
                list2 = list2.next;
            }else if (list1.val<list2.val) {
                pointer.next = list1;
                pointer = pointer.next;
                list1 = list1.next;
            }
        }

        return ans;
    }
}