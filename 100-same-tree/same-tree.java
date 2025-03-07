class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return solve(p,q);
    }

    public boolean solve(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if((root1 == null && root2 != null) || (root1 != null && root2 == null)){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }

        return solve(root1.left,root2.left) && solve(root1.right,root2.right);

    }
}