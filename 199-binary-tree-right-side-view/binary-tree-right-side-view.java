class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return solve(root,ans,0);
    }

    public List<Integer> solve(TreeNode root, List<Integer> ans, int depth){
        if(root == null){
            return ans;
        }

        if(ans.size() == depth){
            ans.add(root.val);
        }else{
            ans.set(depth,root.val);
        }

        solve(root.left,ans,depth+1);
        solve(root.right,ans,depth+1);

        return ans;

    }
}