class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        return dfs(root,1);
    }

    public int dfs(Node root, int depth){
        if(root == null){
            return depth;
        }
        int currDepth = depth;
        for(int i=0; i<root.children.size(); i++){
            Node child = root.children.get(i);
            depth = Math.max(depth,dfs(child,currDepth+1));
        }

        return depth;
    }
}