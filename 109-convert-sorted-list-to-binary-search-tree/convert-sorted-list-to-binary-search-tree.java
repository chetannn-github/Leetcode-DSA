class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int size = 0;
        while(head!=null){
            list.add(head.val);
            head = head.next;
            size++;
        }

        return solve(list,0,size-1);
    }


    public TreeNode solve(List<Integer> nums,int start, int end){
        if(start>end){
            return null;
        }

        int mid = start + ((end - start) >> 1);

        TreeNode root = new TreeNode(nums.get(mid));
        root.left = solve(nums,start,mid-1);
        root.right = solve(nums,mid+1,end);

        return root;
    }
}