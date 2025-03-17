class Solution {
    List<Integer> list;
    // kukii BST KA INORDER TRAVERSALL SORTED HOTAA HH & I KNOW HOW TO CREATE BST USING SORTED ARRAY!!!!!!!!!!
    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        return solve(0,list.size()-1);
    }

    public void inorder(TreeNode root){
        if(root == null ) return;

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);

    }

    public TreeNode solve(int start, int end){
        if(start>end){
            return null;
        }

        int mid = start + ((end - start) >> 1);

        TreeNode root = new TreeNode(list.get(mid));
        root.left = solve(start,mid-1);
        root.right = solve(mid+1,end);

        return root;
    }
}