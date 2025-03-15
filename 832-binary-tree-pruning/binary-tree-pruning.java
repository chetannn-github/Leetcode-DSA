class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return solve(root);
    }


    public TreeNode solve(TreeNode root){
        if(root == null) return null;

        if(root.left != null ) root.left = solve(root.left);
        if(root.right != null ) root.right = solve(root.right);

        if(root.left == null && root.right == null){
            if(root.val == 1) return root;
            else return null;
        }
        return root;
    }


}