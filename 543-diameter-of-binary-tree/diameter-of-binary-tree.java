// class Solution {
//     int maximumDepth;
//     public int diameterOfBinaryTree(TreeNode root) {
//         maximumDepth = 0;
//         solve(root, 1);
//         return maximumDepth - 1;
//     }

//     public int solve(TreeNode root, int currDepth) {
//         if(root == null) return currDepth;

//         int leftDepth = solve(root.left, currDepth + 1);
//         int rightDepth = solve(root.right, currDepth + 1);

    
//         maximumDepth = Math.max(leftDepth + rightDepth + 1 - 2 *(currDepth + 1 ) , maximumDepth);
//         return Math.max(leftDepth, rightDepth);
    
//     }
// }



class Solution {
    int max ;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if(root == null) return -1;
        
    
        int leftDepth = 1 + dfs(root.left);
        int rightDepth = 1 +  dfs(root.right);  

        if(leftDepth + rightDepth > max){
            max = leftDepth + rightDepth;
        }
        
        return Math.max(leftDepth,rightDepth);
    
    }
}
