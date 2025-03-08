class Solution {
    int n;
    public TreeNode buildTree(int[] in, int[] post) {
        n = in.length;
        TreeNode root = new TreeNode(post[n-1],null,null);
        if(n==1 ) return root;
        solve(root,post,in,0,n-1,0,n-1);
        return root;
    }

    public void solve(TreeNode root,int[] post, int[] in, int postStart,int postEnd, int inStart, int inEnd){
        int rootIndexInIn = -1;
        if(postStart>=n || postEnd>=n || postStart>=n || inEnd>=n){
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


        if(leftNodesCount>0) root.left =  new TreeNode(post[postEnd-rightNodesCount-1],null,null);
        
        if(rightNodesCount>0) root.right = new TreeNode(post[postEnd-1],null,null);
        
    
        if(leftNodesCount > 1){
            solve(root.left,post,in, postStart,postEnd-rightNodesCount-1 , inStart, rootIndexInIn-1);
        }
        if(rightNodesCount > 1){
            solve(root.right,post,in, postEnd-rightNodesCount ,postEnd-1 , rootIndexInIn+1 , inEnd);
        }

        return;
    }
}