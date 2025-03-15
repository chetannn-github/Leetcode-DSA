class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return dfs(root1,root2);
    }

    public boolean dfs(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        if(root1.val != root2.val){return false;}

        if(root1.left == null){
            if(root2.left == null) return dfs(root1.right, root2.right);
            else return root2.right == null && dfs(root1.right, root2.left);
        }else if(root1.right == null){
            if(root2.right == null) return dfs(root1.left, root2.left);
            else return root2.left == null && dfs(root1.left, root2.right);

        }else if(root2.left == null){
            if(root1.left == null) return dfs(root1.right, root2.right);
            else return root1.right == null && dfs(root1.left, root2.right);

        }else if(root2.right == null){
            if(root1.right == null) return dfs(root1.left, root2.left);
            else return root1.left == null && dfs(root1.right, root2.left);
        }

        if(root1.left.val == root2.left.val){
            return dfs(root1.left,root2.left) && dfs(root1.right,root2.right);
        }else if(root1.right.val == root2.left.val){
            return dfs(root1.right,root2.left) && dfs(root1.left,root2.right);
        }

        return false;
        
    }
}