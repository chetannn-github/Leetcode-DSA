class Solution {
    int count = 0;
    HashSet<TreeNode> started = new HashSet<>();
    public int pathSum(TreeNode root, int targetSum) {
        solve(root,targetSum,0L);
        return count;
    }


    public void solve(TreeNode root,int targetSum,long currSum) {
        if(root == null) {
            return;
        }

        if(currSum + root.val == targetSum) {
            count++;
        }

        solve(root.left,targetSum,currSum + root.val);
        solve(root.right, targetSum, currSum + root.val);

        if(root.left!= null && !started.contains(root.left) ) {
            started.add(root.left);
            solve(root.left,targetSum,0);
        }
        if(root.right!= null && !started.contains(root.right) ) {
            started.add(root.right);
            solve(root.right,targetSum,0);
        }
    }
}