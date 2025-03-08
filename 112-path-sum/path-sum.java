class Solution {
    public boolean hasPathSum(TreeNode root, int target) {
        return solve(root,target,0);
    }

    public boolean solve(TreeNode root, int target,int curr){
        if(root == null){
            return false;
        }

        return (root.left == null && root.right == null && target == curr + root.val) ||
            (root.left != null && solve(root.left,target,curr + root.val)) || 
            (root.right != null && solve(root.right,target,curr + root.val));
    }
}