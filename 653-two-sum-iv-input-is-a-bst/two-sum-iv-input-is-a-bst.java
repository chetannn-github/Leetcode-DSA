// class Solution {
//     HashSet<Integer> hs;
//     public boolean findTarget(TreeNode root, int k) {
//         hs = new HashSet<>();
//         return solve(root,k);
//     }

//     public boolean solve(TreeNode root, int k){
//         if(root == null) return false;
//         if(hs.contains(k-root.val)) return true;

//         hs.add(root.val);

//         return solve(root.left,k) || solve(root.right,k);
//     }
// }



class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    private boolean dfs(TreeNode node, TreeNode root, int k) {
        if (node == null) 
        return false;

        int target = k - node.val;

        if (target != node.val && search(root, target)) return true;

        return dfs(node.left, root, k) || dfs(node.right, root, k);
    }

    private boolean search(TreeNode node, int val) {
        while (node != null) {
            if (node.val == val) return true;
            else if (node.val < val) node = node.right;
            else node = node.left;
        }
        return false;
    }
}