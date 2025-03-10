class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isEven = true;
        while(!queue.isEmpty()){
            int n = queue.size();
            int last = -1;

            while(n!=0){
                TreeNode curr = queue.remove();
                if(isEven){
                    if(curr.val % 2 == 0 || ( last != -1 && last >= curr.val ) ){
                        return false;
                    }
                }else{
                    if(curr.val % 2 != 0 || (last != -1 && last <= curr.val)){
                        return false;
                    }
                }
                last = curr.val;
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);

                n--;
            }
            isEven = !isEven;
        } 
        return true;
    }
}