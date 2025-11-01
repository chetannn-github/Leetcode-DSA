class Solution {
    long result = 0L;
    int cumSum; 
    int MOD = 1_000_000_007;
    HashMap<TreeNode,Integer> map = new HashMap<>();
    public int maxProduct(TreeNode root) {
        dfs(root);
        cumSum = map.get(root);
        solve(root);
        int modularResult = (int) (result % MOD);
        return modularResult;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        int subTreeSum = leftSum + rightSum + root.val;
        map.put(root,subTreeSum);
        return subTreeSum;

    }

    private void solve(TreeNode root) {
        if(root == null) return;

        if(root.left != null) {
            int left = map.get(root.left) ;
            long prod = (long) left * (cumSum - left);

            result = Math.max(result,prod);
        }

        if(root.right != null) {
            int right = map.get(root.right);
            long prod = (long) right * (cumSum - right);
            result = Math.max(result,prod);
        }
        
        solve(root.left);
        solve(root.right);

    }
}