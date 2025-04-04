class Solution {
    int count = 0;
    int ans = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return ans;
    }


    public void inorder(TreeNode root,int k){
        if(root == null) return;

        inorder(root.left,k);

        if(count == k-1){
            ans = root.val;
            count++;
            return;
        }else{
            count++;
        }

        inorder(root.right,k);

        return;
    }
}