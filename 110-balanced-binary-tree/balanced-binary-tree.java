class Solution {
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    public int dfs(TreeNode root,int currDepth){
        if(!ans) return currDepth;
        if(root == null) return currDepth;
        
        int leftDepth = currDepth;
        int rightDepth = currDepth;
        
        if(root.left != null){leftDepth = dfs(root.left,currDepth+1);}
        if(root.right != null){rightDepth = dfs(root.right,currDepth+1);}

        if(Math.abs(leftDepth- rightDepth) >1){
            ans = false;
        }

        return Math.max(leftDepth,rightDepth);

    }
}