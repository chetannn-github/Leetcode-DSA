class Solution {
    HashSet<Integer> hs;
    public boolean findTarget(TreeNode root, int k) {
        hs = new HashSet<>();
        return solve(root,k);
    }

    public boolean solve(TreeNode root, int k){
        if(root == null) return false;
        if(hs.contains(k-root.val)) return true;

        hs.add(root.val);

        return solve(root.left,k) || solve(root.right,k);
    }
}