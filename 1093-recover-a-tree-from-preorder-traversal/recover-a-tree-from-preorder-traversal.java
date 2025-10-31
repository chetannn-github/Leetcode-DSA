class Solution {
    HashMap<Integer,Integer> nodeToDepth = new HashMap<>();
    List<Integer> preorder = new ArrayList<>();
    int n;
    public TreeNode recoverFromPreorder(String traversal) {
        int depth = 0;
        int node = 0;

        for(int i=0; i<traversal.length(); i++) {
            char ch = traversal.charAt(i);

            if(ch == '-') {
                if(node != 0 ){
                    preorder.add(node);
                    nodeToDepth.put(n,depth);
                    n++;
                    
                    node = 0;
                    depth = 0;
                }
                depth++;
            }else {
                node = (node * 10) + Integer.parseInt(""+ch);
            }
        }
        preorder.add(node);
        nodeToDepth.put(n,depth);
        n++;
        return buildTree(0);
    }
    int idx = 0;
    public TreeNode buildTree(int myDepth) {
        if(idx >= n) return null;

        if(nodeToDepth.get(idx) != myDepth) return null;
        
        TreeNode curr = new TreeNode(preorder.get(idx++));
        curr.left = buildTree(myDepth+1);
        curr.right = buildTree(myDepth+1);
        return curr;
    }
}