class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            long sum = 0;
            int size = n;

            while(n>0){
                TreeNode currRoot = queue.remove();
                sum += currRoot.val;

                if(currRoot.left!=null) queue.add(currRoot.left);
                if(currRoot.right!=null) queue.add(currRoot.right);
                n--;   
            }

            avg.add((double) sum / size);
 
        }

        return avg;
    }
}