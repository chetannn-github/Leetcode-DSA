class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> post = new ArrayList<>();
        return postOrder(root,post);
    }

    public List<Integer> postOrder(TreeNode root,List<Integer> post){
        if(root == null){
            return post;
        }
       
        postOrder(root.left,post);
        postOrder(root.right, post);
        post.add(root.val);
        return post;
    }
}