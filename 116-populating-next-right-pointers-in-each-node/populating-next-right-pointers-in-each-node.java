class Solution {
    public Node connect(Node root) {
        if(root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            Node prev = null;

            while(n!=0){
                Node curr = queue.remove();
                if(prev != null) prev.next = curr;
                    
                prev = curr;
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                n--;
            }
        }

        return root;
    }
}