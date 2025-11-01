class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while(!queue.isEmpty()) {
            int currSize = queue.size();

            while(currSize-->0) {
                TreeNode curr = queue.remove();
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            depth++;
        }

        int maxDepth = depth;
        depth = 0;
        queue.add(root);
        while(!queue.isEmpty()) {
            int currSize = queue.size();
            if(depth == maxDepth - 1) break;
            while(currSize-->0) {
                TreeNode curr = queue.remove();
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            depth++;
        }

        while(queue.size() > 1) {
            queue.add(LCA(root,queue.remove(), queue.remove()));
        }

        return queue.remove();
    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ||root == p || root == q){
            return root;
        }

        TreeNode left =LCA(root.left,p,q);
        TreeNode right =LCA(root.right,p,q);

        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;
    }

    
}