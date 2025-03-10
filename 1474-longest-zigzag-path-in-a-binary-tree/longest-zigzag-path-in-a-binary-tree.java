class Solution {
    public int longestZigZag(TreeNode root) {
        return solve(root, true,0);
    }
    public int solve(TreeNode root,boolean goLeft, int score){
        if(root == null ) return score -1 ;

        int ans = Integer.MIN_VALUE;
        if(goLeft){
            ans = Math.max(ans, solve(root.left, !goLeft , score+1));
            ans = Math.max(ans, solve(root.right,true,1));
        }else{
            ans = Math.max(ans, solve(root.left, false,1));
            ans = Math.max(ans, solve(root.right, !goLeft, score +1 ));
        }
        return ans;
    }
}