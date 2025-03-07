class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> in = new ArrayList<>();
        return inOrder(root,in);
    }

    public List<Integer> inOrder(TreeNode root,List<Integer> in){
        if(root == null){
            return in;
        }
        
        inOrder(root.left,in);
        in.add(root.val);
        inOrder(root.right, in);
        return in;
    }
}