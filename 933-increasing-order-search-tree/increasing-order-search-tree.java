// class Solution {
//     public TreeNode increasingBST(TreeNode root) {
//      List<Integer> list = new ArrayList<>();
        
//         inorder(root,list);
//         TreeNode newRoot = insert(null,list.get(0));
//         for(int i=1; i<list.size(); i++){
//             insert(newRoot,list.get(i));
//         }

//         return newRoot;
//     }

//     public void inorder(TreeNode root,List<Integer> list){
//         if(root == null ) return;

//         inorder(root.left,list);
//         list.add(root.val);
//         inorder(root.right,list);
//     }

//     TreeNode insert(TreeNode root,int val){
//         if(root == null){
//             return new TreeNode(val);
//         }

//         if(root.val > val){
//             root.left = insert(root.left,val);
//         }
//         if(root.val < val){
//             root.right = insert(root.right,val);
//         }

//         return root;
//     }
// }



class Solution {
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        curr = new TreeNode(0);
        TreeNode start = curr;
        inorder(root);
        return start.right;
    }

    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        curr.right = root;
        root.left = null;
        curr = root;
        inorder(root.right);

    }
}