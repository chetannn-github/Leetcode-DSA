class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        solve(root,0);
        return result; 
        
    }

    public void solve(TreeNode root,int curr){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null ){
            result += curr*10 + root.val;
            return;
        }

        if(root.left != null){
            solve(root.left,curr*10 + root.val);
        }

        if(root.right != null){
            solve(root.right,curr*10 + root.val);
        }
        return;
    }
}