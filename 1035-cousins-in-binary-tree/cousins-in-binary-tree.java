class Solution {
    int depthX , depthY;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.left == null || root.right == null || root.val == x || root.val ==y) return false;
        int[] depth = {-1,-1};
    
        return dfs(root,x,y,0,depth);
    }
    public boolean dfs(TreeNode root,int x, int y,int currDepth, int[] depth){
        
        if(root.left !=null && root.right!=null && ((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x))){
            return false;
        }else if((root.left !=null && root.left.val == x) || (root.right!=null &&root.right.val == x)){
            if(depth[1] != -1){
                return depth[1] == currDepth;
            }else{
                depth[0] = currDepth;
            }
        }else if((root.left !=null && root.left.val == y) || (root.right!=null && root.right.val == y)){
            if(depth[0] != -1){
                return depth[0] == currDepth;
            }else{
                depth[1] = currDepth;
            }
        }
        boolean ans = true;
        if(root.left != null) ans = ans && dfs(root.left,x,y,currDepth+1,depth);
        if(root.right != null) ans = ans && dfs(root.right,x,y,currDepth+1,depth);

        
        return ans;
    }
}