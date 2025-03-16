class Solution {
    List<Integer> levelSum ;
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        levelSum = new ArrayList<>();

        while(!queue.isEmpty()){
            int n = queue.size();
            int currLevelSum = 0;
            while(n!=0){
                TreeNode curr = queue.remove();
                currLevelSum += curr.val;

                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
                n--; 
            }
            levelSum.add(currLevelSum);
        }

        dfs(root,0);
        root.val = 0;
        return root;
    }

    public void dfs(TreeNode root,int currDepth){
        if(root == null) return;
        if(root.left == null && root.right == null) return;

        if(root.left != null && root.right != null){
            int temp = root.left.val;
            root.left.val = levelSum.get(currDepth +1) - root.right.val - root.left.val;
            root.right.val = levelSum.get(currDepth +1) - root.right.val - temp;
            dfs(root.left,currDepth+1);
            dfs(root.right,currDepth+1);
            
        }else if(root.left == null ){
            root.right.val = levelSum.get(currDepth +1) - root.right.val;
            dfs(root.right,currDepth+1);
        }else if(root.right == null ){
            root.left.val = levelSum.get(currDepth +1) - root.left.val;
            dfs(root.left,currDepth+1);
        }
        
    }
}