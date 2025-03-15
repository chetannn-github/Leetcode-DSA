class FindElements {
    HashSet<Integer> values;
    public FindElements(TreeNode root) {
        values = new HashSet<>();
        values.add(0);
        dfs(root.left,1);
        dfs(root.right,2);
    }

    public void dfs(TreeNode root,int currVal){
        if(root == null) return;
        values.add(currVal);
        if(root.left != null) dfs(root.left,currVal*2 + 1);
        if(root.right != null) dfs(root.right,currVal*2 + 2);
    }
    
    public boolean find(int target) {
        return values.contains(target);
    }
}

