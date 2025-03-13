class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) return new TreeNode(val,root,null);
        solve(root,val,depth,1);
        return root;
    }

    public void solve(TreeNode root,int val,int depth, int currDepth){
        if(root == null) return;

        if(depth-1 == currDepth ){
            TreeNode newNodeLeft = new TreeNode(val,root.left,null);
            TreeNode newNodeRight = new TreeNode(val,null,root.right);

            root.left = newNodeLeft;
            root.right = newNodeRight;
            return;
        }

        
        solve(root.left,val,depth,currDepth+1);
        solve(root.right,val,depth,currDepth+1);
    }
}