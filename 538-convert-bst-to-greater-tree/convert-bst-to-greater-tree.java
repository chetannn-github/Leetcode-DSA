class Solution {
    int acc;
    public TreeNode convertBST(TreeNode root) {
        acc = 0;
        reverseInorder(root);
        return root; 
        
    }

    public void reverseInorder(TreeNode root){
        if(root == null) return ;

        reverseInorder(root.right);

        root.val = acc + root.val;
        acc = root.val;
        
        reverseInorder(root.left);
    }
}