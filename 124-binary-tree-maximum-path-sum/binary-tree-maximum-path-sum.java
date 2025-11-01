class Solution {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        int opt1 = leftSum + rightSum + root.val;
        int opt2 = root.val;
        int opt3 = leftSum + root.val;
        int opt4 = rightSum + root.val;
        int maxResult = Math.max(Math.max(opt1,opt2), Math.max(opt3,opt4));
        result = Math.max(result,maxResult);
        return Math.max(opt2,Math.max(opt3,opt4));
    }
}