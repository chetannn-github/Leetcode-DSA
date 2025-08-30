class Solution {
    public int maxDepth(TreeNode root) {
        return solve(root);
    }

    public int solve(TreeNode root) {
        if(root == null ) return 0;

        int leftDepth = solve(root.left);
        int rightDepth = solve(root.right);
        
        return 1 + Math.max(leftDepth,rightDepth);
    }
}