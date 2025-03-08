class Solution {
    int n;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        n = post.length;
        TreeNode root = new TreeNode(post[n-1],null,null);
        if(n==1 ) return root;
        solve(root,post,pre,0,n-1,0,n-1);
        return root;
    }

    public void solve(TreeNode root,int[] post, int[] pre, int postStart,int postEnd, int preStart, int preEnd){
        int rightIndexInPre = -1;
        if(postStart>=n || postEnd>=n || preStart>=n || preEnd>=n){
            return;
        }
        int rightMost = post[postEnd-1];

        for(int i = preStart; i<=preEnd; i++){
            if(pre[i] == rightMost){
                rightIndexInPre = i;
                break;
            }
        }
        int leftNodesCount = rightIndexInPre - preStart -1;
        int rightNodesCount = preEnd - rightIndexInPre + 1;


        if(leftNodesCount>0) root.left =  new TreeNode(pre[preStart+1],null,null);
        
        if(rightNodesCount>0) root.right = new TreeNode(post[postEnd-1],null,null);
        
    
        if(leftNodesCount > 1){
            solve(root.left,post,pre, postStart,postStart+leftNodesCount-1 , preStart+1,preStart+leftNodesCount);
        }
        if(rightNodesCount > 1){
            solve(root.right,post,pre, postStart+leftNodesCount ,postEnd-1 ,preStart+leftNodesCount+1, preEnd);
        }

        return;
    }
}