class Solution {
    int max ;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
    
        int leftDepth = 1 + dfs(root.left);
        int rightDepth = 1 +  dfs(root.right);  

        if(leftDepth + rightDepth -2 > max){
            max = leftDepth + rightDepth -2 ;
        }
        
        return Math.max(leftDepth,rightDepth);
    
    }
}