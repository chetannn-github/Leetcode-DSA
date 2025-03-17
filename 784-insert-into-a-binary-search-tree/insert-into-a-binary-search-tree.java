class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root,val);
    }

    TreeNode insert(TreeNode root,int val){
        if(root == null){
            return new TreeNode(val);
        }

        if(root.val > val){
            root.left = insert(root.left,val);
        }
        if(root.val < val){
            root.right = insert(root.right,val);
        }

        return root;
    }
}