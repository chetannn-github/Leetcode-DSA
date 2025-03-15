class Solution {
    HashMap<TreeNode,TreeNode> hm = new HashMap<>();
    TreeNode startNode;
    int start ;
    public int amountOfTime(TreeNode root, int start) {
        this.start = start;
        dfs(root);
        HashSet<Integer> hs = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startNode);
        hs.add(startNode.val);

        int time = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            time++;

            while(n!=0){
                TreeNode curr = queue.remove();

                if(curr.left != null && !hs.contains(curr.left.val)) {queue.add(curr.left);hs.add(curr.left.val);}
                if(curr.right != null && !hs.contains(curr.right.val)){ queue.add(curr.right);hs.add(curr.right.val);}
                if(hm.containsKey(curr) && !hs.contains(hm.get(curr).val)) { queue.add(hm.get(curr));hs.add(hm.get(curr).val);}
                n--;

            }
        }

        return time-1;

    }

    public void dfs(TreeNode root){
        if(root.val == start){
            startNode = root;
        }
        
        if(root.left != null) {
            dfs(root.left);
            hm.put(root.left,root);
        }
        if(root.right != null){
            dfs(root.right); 
            hm.put(root.right,root);
        }
        return ;
    }
}