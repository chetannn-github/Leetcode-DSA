class Solution {
    public int countNodes(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
    
        int leftDepth = 1 + dfs(root.left);
        int rightDepth = dfs(root.right);  

        return leftDepth + rightDepth;
    
    }
}