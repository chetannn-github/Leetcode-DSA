class Solution {
    int n;
    public TreeNode buildTree(int[] pre, int[] in) {
        n = pre.length;
        TreeNode root = new TreeNode(pre[0],null,null);
        if(n==1 ) return root;
        solve(root,pre,in,0,n-1,0,n-1);
        return root;
    }

    public void solve(TreeNode root,int[] pre, int[] in, int preStart,int preEnd, int inStart, int inEnd){
        int rootIndexInIn = -1;
        if(preStart>=n || preEnd>=n || preStart>=n || inEnd>=n){
            return;
        }
        for(int i = inStart; i<=inEnd; i++){
            if(in[i] == root.val){
                rootIndexInIn = i;
                break;
            }
        }
        int leftNodesCount = rootIndexInIn - inStart;
        int rightNodesCount = inEnd - rootIndexInIn;
        if(leftNodesCount>0) root.left = new TreeNode(pre[preStart+1],null,null);
        
        
        if(rightNodesCount>0) root.right =  new TreeNode(pre[preStart+leftNodesCount+1],null,null);
        
    
        if(leftNodesCount > 1){
            solve(root.left,pre,in, preStart+1 ,preStart + leftNodesCount , inStart, rootIndexInIn-1);
        }
        if(rightNodesCount > 1){
            solve(root.right,pre,in, preStart+leftNodesCount+1 ,preEnd , rootIndexInIn+1 , inEnd);
        }

        return;
    }
}