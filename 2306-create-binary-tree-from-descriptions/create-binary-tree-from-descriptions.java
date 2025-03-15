class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> hm = new HashMap<>();
        HashSet<Integer> childrenSet = new HashSet<>();
        

        for(int[] row : descriptions){
            int parent = row[0];
            int child = row[1];
            int isLeft = row[2];

            childrenSet.add(child);
            if(!hm.containsKey(parent)) hm.put(parent,new TreeNode(parent));
            if(!hm.containsKey(child)) hm.put(child,new TreeNode(child));

            TreeNode p = hm.get(parent);
            TreeNode c = hm.get(child);

            if(isLeft == 1) p.left = c;
            else p.right = c;
            
        }
        for(int[] row : descriptions){
            if(!childrenSet.contains(row[0])) return hm.get(row[0]);
        }
        
        return hm.get(0);
    }
}