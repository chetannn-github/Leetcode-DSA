class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> max = new ArrayList<>();
        if(root == null) return max;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int n = queue.size();
            int maxVal = Integer.MIN_VALUE;

            while(n!= 0){
                TreeNode curr = queue.remove();
                maxVal = Math.max(maxVal,curr.val);

                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                n--;
            }
            max.add(maxVal);
        }
        return max;     
    }
}