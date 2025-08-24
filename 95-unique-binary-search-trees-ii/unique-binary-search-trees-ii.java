class Solution {
    List<TreeNode>[][] dp;
    public List<TreeNode> generateTrees(int n) {
        dp = new ArrayList[n+1][n+1];
        return solve(1,n);
    }


    public List<TreeNode> solve(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if(start > end ) {
            result.add(null);
            return result;
        }
        if(start == end) {
            result.add(new TreeNode(start));
            return result;
        }

        if(dp[start][end] != null) return dp[start][end];

        for(int i=start; i<=end; i++) {
            List<TreeNode> leftRes = solve(start, i-1);
            List<TreeNode> rightRes = solve(i+1, end);
            

            for(TreeNode left : leftRes) {
                for(TreeNode right : rightRes) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }



        return dp[start][end] = result;
    }
}