class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder,0,preorder.length-1); 
    }

    public TreeNode solve(int[] preorder,int start, int end){
        if(start > end) return null;

        TreeNode root = new TreeNode(preorder[start]);
        // root se chote wale kha tk aarhe hh
        int leftMost = start;
        for(int i=start+1; i<=end; i++){
            if(preorder[i] < preorder[start]){
                leftMost = i;
            }else{
                break;
            }
        }

        root.left = solve(preorder,start+1,leftMost);
        root.right = solve(preorder,leftMost+1,end);
        return root;
    }
}