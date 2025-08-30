class Solution {
    public int minDepth(TreeNode root) {
        
        
        return solve(root);
    }

    public int solve(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null) return 1 + solve(root.right);
        if(root.right == null) return 1 + solve(root.left);
        
        int leftDepth = solve(root.left);
        int rightDepth = solve(root.right);
        return 1 + Math.min(leftDepth, rightDepth);
    }
}