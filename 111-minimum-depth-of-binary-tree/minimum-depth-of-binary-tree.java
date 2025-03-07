class Solution {
    public int minDepth(TreeNode root) { 
        return dfs(root);
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftDepth = 1 + dfs(root.left);
        int rightDepth = 1 + dfs(root.right);
        int min = Math.min(leftDepth, rightDepth);
        int max = Math.max(leftDepth, rightDepth);

        return min == 1 ? max : min;
       
    }
}