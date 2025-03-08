
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result =  new ArrayList<>();
        if(root == null ) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();

            while(n>0){
                TreeNode curr = queue.remove();
                temp.add(curr.val);
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                n--;
            }

            result.add(new ArrayList<>(temp));
        }
        
        return result;  
    }
}