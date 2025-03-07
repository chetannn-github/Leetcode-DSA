class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean past = false;

        while(!queue.isEmpty()){
            TreeNode currRoot = queue.remove();

            if(currRoot == null){
                past = true;
            }else{
                if(past){
                    return false;
                }
                queue.add(currRoot.left);
                queue.add(currRoot.right);
            }
        }

        return true;
    }
}