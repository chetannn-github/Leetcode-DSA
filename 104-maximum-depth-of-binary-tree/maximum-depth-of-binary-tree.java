class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftDepth = 1 + dfs(root.left);
        int rightDepth = 1 + dfs(root.right);

        
        return Math.max(leftDepth, rightDepth);
    }
}