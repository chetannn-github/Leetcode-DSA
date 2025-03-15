class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int swaps = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();

            while(n!=0){
                TreeNode curr = queue.remove();
                temp.add(curr.val);
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                n--;
            }
            swaps += countSwaps(temp); 
        }
        return swaps;
    }

    public int countSwaps(List<Integer> temp){
        HashMap<Integer,Integer> hm  = new HashMap<>();
        List<Integer> sorted = new ArrayList<>();
        int size = temp.size();
        int swaps = 0;
        
        for(int i=0; i<size; i++){
            int val = temp.get(i);
            hm.put(val,i);
            sorted.add(val);
        }

        Collections.sort(sorted);
        for(int i=0; i<size; i++){
            int val1 = temp.get(i);
            int val2 = sorted.get(i);

            if(val1 != val2){
                int indexOfVal2 = hm.get(val2);

                temp.set(i,val2);
                temp.set(indexOfVal2,val1);
                swaps++;
                hm.put(val1, indexOfVal2);
                hm.put(val2,i);
            }
            
        }
    

        return swaps;
    }
}