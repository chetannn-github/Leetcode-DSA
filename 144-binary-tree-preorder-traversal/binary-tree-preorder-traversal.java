class Solution {
    List<Integer> result;
    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        solve(root);
        return result;
    }

    public void solve(TreeNode root) {
        if(root == null) return;

        result.add(root.val);
        solve(root.left);
        solve(root.right);
    }
}