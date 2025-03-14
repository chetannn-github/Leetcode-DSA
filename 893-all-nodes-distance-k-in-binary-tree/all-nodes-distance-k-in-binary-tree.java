class Solution {
    HashMap<TreeNode,TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        dfs(root);

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        visited.add(target.val);
        queue.add(target);

        while(!queue.isEmpty()){
            int n = queue.size();
            
            while(n!=0){
                TreeNode curr = queue.remove();
                if(k==0){
                    ans.add(curr.val);
                }else{
                    if(curr.left != null && !visited.contains(curr.left.val)) {
                        queue.add(curr.left);
                        visited.add(curr.left.val);
                    }
                    if(curr.right != null && !visited.contains(curr.right.val)){
                        queue.add(curr.right);
                        visited.add(curr.right.val);
                    }
                    if(parent.containsKey(curr) && !visited.contains(parent.get(curr).val)){ 
                        queue.add(parent.get(curr)); 
                        visited.add(parent.get(curr).val);
                    }
                }
                n--;
            }
            k--;
        }

        return ans;
    }

  
    public void dfs(TreeNode root){
       
        if(root.left != null){ 
            parent.put(root.left,root);
            dfs(root.left);
        }
        if(root.right != null){ 
            parent.put(root.right,root);
            dfs(root.right);
        }
        
        
    }


}