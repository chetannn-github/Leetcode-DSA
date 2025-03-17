class Solution {
    public boolean isValidBST(TreeNode root) {
        // method 1 is simple find inorder traversal check is it sorted 
        // m2 hum range bata degee kii buddy iss range ke alawa iss subtree me nhii
        // hona chaiyee
        return solve(root,-2512,-2512);
    }

    public boolean solve(TreeNode root, int min, int max){
        if(root == null) return true;

        if(min != -2512 && root.val <= min){
            return false;
        }
        if(max != -2512 && root.val >= max){
            return false;
        }

        return solve(root.left,min,root.val) && solve(root.right,root.val,max);
    }
}