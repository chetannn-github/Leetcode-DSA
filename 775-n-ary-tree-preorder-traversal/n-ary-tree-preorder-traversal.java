

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root!= null) ans.add(root.val);
        return dfs(root,ans);
    }

    public List<Integer> dfs(Node root, List<Integer> ans){
        if(root == null){
            return ans;
        }
        
        
        for(int i=0;i<root.children.size(); i++){
            Node child = root.children.get(i);
            ans.add(child.val);
            dfs(child,ans);
        }

        return ans;
    }
}