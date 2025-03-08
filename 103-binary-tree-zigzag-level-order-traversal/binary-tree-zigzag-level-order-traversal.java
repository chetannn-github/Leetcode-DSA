class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        int n = result.size();

        for(int i=1; i<n; i+=2){
            result.set(i,reverse(result.get(i)));
        }
        return result;

    }

    public List<Integer> reverse(List<Integer> list){
        int n = list.size();

        for(int i=0; i<n/2; i++){
            int temp = list.get(i);
            list.set(i,list.get(n-1-i));
            list.set(n-1-i,temp);
        }
        return list;
    }
}