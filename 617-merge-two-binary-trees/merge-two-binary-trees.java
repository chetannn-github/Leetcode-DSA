class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null ) return root2;
        if(root2 == null ) return root1;
        solve(root1,root2);
        return root1;
    }

    public void solve(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return;
        boolean leftNhiJanaHain = false;
        boolean rightNhiJanaHain = false;

        if(root1.left == null && root2.left != null){
            root1.left = root2.left;
            leftNhiJanaHain = true;
        }
        if(root1.left != null && root2.left == null){
            leftNhiJanaHain = true;
        }
        if(root1.right == null && root2.right != null){
            root1.right = root2.right;
            rightNhiJanaHain = true;
        }
        if(root1.right != null && root2.right == null){
            rightNhiJanaHain = true;
        }
        root1.val += root2.val;
        
        
        if(!leftNhiJanaHain) solve(root1.left,root2.left);
        if(!rightNhiJanaHain) solve(root1.right,root2.right);

        return;
        
    }
}