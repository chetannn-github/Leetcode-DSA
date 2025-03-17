class Solution {
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        
        inorder(root1,list);
        inorder(root2,list);

        Collections.sort(list);
        return list;
    }

    public void inorder(TreeNode root,List<Integer> list){
        if(root == null ) return;

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    
   
}