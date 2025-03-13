class Solution {
    List<TreeNode> forest;
    HashSet<Integer> hs;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        forest = new ArrayList<>();
        hs = new HashSet<>();

        for(int nodeVal : to_delete){
            hs.add(nodeVal);
        }

        if (solve(root) != null){
            forest.add(root);
        }

        return forest;
    }

    public TreeNode solve(TreeNode root) {
        if(root == null) return null;

        root.left = solve(root.left);
        root.right = solve(root.right);

        if(hs.contains(root.val)){
            if(root.left != null){forest.add(root.left);}
            if(root.right != null){forest.add(root.right);}

            return null;
        }
        return root;
    }
}