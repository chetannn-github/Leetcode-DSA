class BSTIterator {
    List<Integer> list;
    int curr;
    int size;
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        this.curr = 0;
        this.size = 0;
        inorder(root);
    }
    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        list.add(root.val);
        size++;
        inorder(root.right);
    }
    
    public int next() {
        return list.get(curr++);
    }
    
    public boolean hasNext() {
        return curr < size;
    }
}
