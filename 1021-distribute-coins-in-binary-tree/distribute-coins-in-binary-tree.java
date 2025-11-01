class Solution {
    int steps = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return steps;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        steps += Math.abs(left) + Math.abs(right);

        return root.val - 1 + left + right;
    }
}