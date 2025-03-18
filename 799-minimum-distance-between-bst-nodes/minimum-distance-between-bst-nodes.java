class Solution {
    
    int minDiff;
    public int minDiffInBST(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        dfs(root);
        return minDiff;
    }

    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        int min = IP(root.left);
        int max = IS(root.right);
        
        if(min != -1){
            minDiff = Math.min(root.val-min, minDiff);
        }

        if(max != -1){
             minDiff = Math.min(max - root.val, minDiff);
        }

        dfs(root.right);
        
        return ;
    }

    public int IP(TreeNode root){
        if(root == null) return -1;

        int inorderPredecessor = root.val;
        while(root.right !=null){
            root = root.right;
            inorderPredecessor = root.val;
        }

        return inorderPredecessor;
    }

    public int IS(TreeNode root){
        if(root == null) return -1;

        int inorderSuccessor = root.val;
        while(root.left!=null){
            root = root.left;
            inorderSuccessor = root.val;
        }

        return inorderSuccessor;
    }
}
