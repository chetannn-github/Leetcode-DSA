class Solution {
    public boolean isSymmetric(TreeNode root) {
        return solve(root.left,root.right);
    }

    public boolean solve(TreeNode one, TreeNode two){
        if(one == null && two == null ) return true;
        if(one == null || two == null ) return false;

        if(one.val != two.val) return false;

        return solve(one.left,two.right) && solve(one.right,two.left);
    }
}