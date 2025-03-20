class Solution {
    int val;
    public boolean isUnivalTree(TreeNode root) {
        val = root.val;
        return solve(root);
    }

    public boolean solve(TreeNode root){
        if(root == null) return true;

        if(root.val != val) return false;
        
        return solve(root.left ) && solve(root.right);
            
    }
}