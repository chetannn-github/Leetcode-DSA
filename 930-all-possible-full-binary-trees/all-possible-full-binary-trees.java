class Solution {
    List<TreeNode>[] dp;
    public List<TreeNode> allPossibleFBT(int n) {
        dp = new List[n+1];
        return solve(n);
    }

    public List<TreeNode> solve(int n) {
        if((n & 1) == 0) return new ArrayList<>();
        List<TreeNode> result = new ArrayList<>();
        if(n == 1) {
            result.add(new TreeNode(0));
            return result;
        }

        if(dp[n] != null) return dp[n];


        int childNodes = n - 1;

        for(int leftNodesCount = 1; leftNodesCount <= childNodes - 1; leftNodesCount +=2) {
            List<TreeNode> leftRes = solve(leftNodesCount);
            List<TreeNode> rightRes = solve(childNodes - leftNodesCount);

            for(TreeNode left : leftRes) {
                for(TreeNode right : rightRes) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return dp[n] = result;
    }
}