class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int bottomLeft = -1;
        
        while(!queue.isEmpty()){
            int n = queue.size();
            bottomLeft = queue.peek().val;
            
            while(n!=0){
                TreeNode curr = queue.remove();
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right );
                n--;
            }
        }

        return bottomLeft;
    }
}