class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean odd = false;
        while(!queue.isEmpty()){
            int n = queue.size();
            List<TreeNode> list = new ArrayList<>();

            while(n!=0){
                TreeNode curr = queue.remove();
                if(odd) list.add(curr);
                
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                n--;
            }
            if(odd){
                int size = list.size();
                for(int i=0; i<size/2; i++){
                    Integer temp = list.get(i).val;
                    list.get(i).val = list.get(size-1-i).val;
                    list.get(size-1-i).val = temp;
                }
            }
            
            odd = !odd;
        }

        return root;
    }
}