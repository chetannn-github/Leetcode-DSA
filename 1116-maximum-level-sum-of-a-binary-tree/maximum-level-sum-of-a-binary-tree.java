class Solution {
    
    public int maxLevelSum(TreeNode root) {
        int max = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;
        int maxLevel = 1;

        while(!queue.isEmpty()){
            int n = queue.size();
            int sum = 0;

            while(n!=0){
                TreeNode currNode = queue.remove();
                sum += currNode.val;

                if(currNode.right != null) queue.add(currNode.right);
                if(currNode.left != null) queue.add(currNode.left);
                n--;
            }

            if(sum>max){
                max = sum;
                maxLevel = level;
            }
            level++;
            
        }
        return maxLevel;
        
    }
}