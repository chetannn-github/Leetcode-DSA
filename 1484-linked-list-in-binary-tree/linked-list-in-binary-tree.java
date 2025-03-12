class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(curr.val == head.val){
                if (check(head.next,curr.left)) return true;
                if (check(head.next,curr.right)) return true;
            }
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }

        return false;
    }

    public boolean check(ListNode head, TreeNode root){
        if(head == null ) return true;
        if(root == null ) return false;

        if(head.val != root.val) return false; 

        return check(head.next,root.left) || check(head.next,root.right);
    }
}