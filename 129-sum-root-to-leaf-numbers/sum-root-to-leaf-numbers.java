class Solution {
    public int sumNumbers(TreeNode root) {
        return solve(root,0,0);
    }

    public int solve(TreeNode root,int curr,int result){
        if(root == null){
            return result;
        }
        if(root.left == null && root.right == null ){
            result += curr*10 + root.val;
            return result;
        }

        if(root.left != null){
            result = solve(root.left,curr*10 + root.val,result);
        }

        if(root.right != null){
            result = solve(root.right,curr*10 + root.val,result);
        }
        return result;
    }
}