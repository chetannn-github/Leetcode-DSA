class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>(); 
        dfs(root,ans);
        if(root!= null) ans.add(root.val);
        return ans;
    }

    public List<Integer> dfs(Node root, List<Integer> ans){
        if(root == null){
            return ans;
        }
        
        
        for(int i=0;i<root.children.size(); i++){
            Node child = root.children.get(i);
            dfs(child,ans);
            ans.add(child.val);
        }

        return ans;
    }
}
