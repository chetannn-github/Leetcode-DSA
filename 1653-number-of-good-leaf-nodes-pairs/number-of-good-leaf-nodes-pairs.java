class Solution {
    int count;
    public int countPairs(TreeNode root, int distance) {
        count = 0;
        dfs(root,distance);
        return count;
    }

    public List<Integer> dfs(TreeNode root, int distance){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }

        if(root.left == null && root.right == null){
            ans.add(1);
            return ans;
        }
        List<Integer> left = dfs(root.left,distance);
        List<Integer> right = dfs(root.right,distance);
    
        
        for(Integer leftDis : left){
            for(Integer rightDis :right){
                if(leftDis + rightDis <= distance) count++;
            }
        }

        for (Integer leftDis : left) ans.add(leftDis + 1);
        for (Integer rightDis : right) ans.add(rightDis + 1);
        
        return ans;

    }
}