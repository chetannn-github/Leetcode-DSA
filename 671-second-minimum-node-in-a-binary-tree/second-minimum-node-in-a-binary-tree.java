class Solution {
    int min = -1;
    int secondMin = -1;
    public int findSecondMinimumValue(TreeNode root) {
        solve(root);
        return secondMin;
    }

    public void solve(TreeNode root){
        if(root == null) return;

        if(min == -1 || min > root.val){
            secondMin = min;
            min = root.val;
            
        }else if(root.val != min && (secondMin == -1 || secondMin > root.val) ){
            secondMin = root.val;
        }

        solve(root.left);
        solve(root.right);
    }
}