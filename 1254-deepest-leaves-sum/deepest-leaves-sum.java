class Solution {
    int maxDepth = -1;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        solve(root,0);
        return sum;
    }

    public void solve(TreeNode root, int currDepth){
        if(root == null) return ;

        if(currDepth > maxDepth){
            sum = root.val;
            maxDepth = currDepth;
        }else if(currDepth == maxDepth){
            sum += root.val;
        }

        solve(root.left,currDepth+1);
        solve(root.right,currDepth+1);

        return;

    }
}