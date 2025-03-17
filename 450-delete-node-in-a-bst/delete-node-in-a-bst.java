class Solution {
    public TreeNode deleteNode(TreeNode root, int val) {
        return delete(root,val);
    }

    public TreeNode delete(TreeNode root, int val){
        if(root == null) return root;
        if(root.val < val){
            root.right = delete(root.right,val);
        }else if(root.val > val){
            root.left = delete(root.left,val);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            TreeNode IS = findInorderSuccessor(root.right);
            root.val = IS.val;
            root.right = delete(root.right,IS.val);
        }
        return root;
    }


    public TreeNode findInorderSuccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }
}