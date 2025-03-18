class Solution {
    TreeNode prev = null;
    boolean phelibaar = true;
    TreeNode prevINeed = null;
    TreeNode jisseSwapKrnaHain = null;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = prevINeed.val;
        prevINeed.val = jisseSwapKrnaHain.val;
        jisseSwapKrnaHain.val = temp;
    }

    public void inorder(TreeNode root){
        if(root == null) return ;
        
        inorder(root.left);
        
        if(prev == null){
            prev = root;
        }else if(prev.val > root.val){
            if(phelibaar){
                prevINeed = prev;
                phelibaar = false;
            }
            jisseSwapKrnaHain = root;
        }
        prev = root;

        inorder(root.right);
    }
}