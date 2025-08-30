// class Solution {
//     boolean isBalanced = true;
//     public boolean isBalanced(TreeNode root) {
//         solve(root, 0);
//         return isBalanced;
//     }

//     public int solve(TreeNode root, int depth ) {
//         if(root == null) return depth;
//         if(!isBalanced) return depth;

//         int depthLeft = solve(root.left, depth + 1);
//         int depthRight = solve(root.right, depth + 1);
//         if(isBalanced) isBalanced = Math.abs(depthLeft - depthRight) <= 1;

//         return Math.max(depthLeft, depthRight);
//     }
// }



class Solution {
    
    public boolean isBalanced(TreeNode root) {
        return solve(root) != Integer.MAX_VALUE;
    }

    public int solve(TreeNode root) {
        if(root == null) return 0;

        int depthLeft = solve(root.left);
        int depthRight = solve(root.right);
        
        if(depthLeft == Integer.MAX_VALUE) return depthLeft;
        if(depthRight == Integer.MAX_VALUE) return depthRight;

        if(Math.abs(depthLeft - depthRight) > 1) return Integer.MAX_VALUE;


        return 1 + Math.max(depthLeft, depthRight);
    }
}