class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int max = root.val;
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root,0));

        int maxWidth = 1;
        
        while(!queue.isEmpty()){
            int n = queue.size();
            int left = -1;
            int right = -1;
            
            while(n!=0){
                Pair<TreeNode,Integer> curr = queue.remove();
                TreeNode currNode = curr.getKey();
                Integer idx = curr.getValue();

                if(left == -1){
                    right = idx;
                    left = idx;
                }else{
                    right = idx;
                }
                if(currNode.left != null ) queue.add(new Pair<>(currNode.left,2*idx +1));
                if(currNode.right != null ) queue.add(new Pair<>(currNode.right,2*idx +2));
                

                n--;
            }
            int currWidth = right - left +1;
            maxWidth = Math.max(currWidth,maxWidth);
            
            
        }
        return maxWidth;    
    }
}




// tle
// class Solution {
//     public int widthOfBinaryTree(TreeNode root) {
//         int max = root.val;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);

//         int maxWidth = 1;
//         boolean isAllNULL = false;

//         while(!queue.isEmpty() && !isAllNULL){
//             isAllNULL = true;
//             int n = queue.size();
//             int left = -1;
//             int right = -1;
            
//             while(n!=0){
//                 TreeNode currNode = queue.remove();
//                 if(currNode != null){
//                     isAllNULL = false;
//                     if(right == -1){
//                         right = n;
//                         left = n;
//                     }else{
//                         left = n;
//                     }
//                     queue.add(currNode.right);
//                     queue.add(currNode.left);
//                 }

//                 if(currNode == null){
//                     queue.add(null);
//                     queue.add(null);
//                 }
//                 n--;
//             }
//             int currWidth = right - left +1;
//             maxWidth = Math.max(currWidth,maxWidth);
            
            
//         }
//         return maxWidth;    
//     }
// }