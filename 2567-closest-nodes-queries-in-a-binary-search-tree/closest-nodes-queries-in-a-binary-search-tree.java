class Solution {
    // it is more like upper bound and lower bound in binary search
    List<Integer> in;
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = queries.size();
        in = new ArrayList<>();
        inorder(root);

        for(int i=0; i<n; i++){
            int q = queries.get(i);
            int size = in.size();
            int idx = bs(0,size-1,q);

            List<Integer> currAns = new ArrayList<>();

            if(idx == -1){
               currAns.add(in.get(size-1));
               currAns.add(-1);
            }else if(idx == 0 && in.get(0) != q){
                currAns.add(-1);
                currAns.add(in.get(0));
            }else if (in.get(idx) == q){
                currAns.add(q);
                currAns.add(q);
            }else{
                currAns.add(in.get(idx-1));
                currAns.add(in.get(idx));
            }
            ans.add(currAns);
        }

        return ans;
        
    }

    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        in.add(root.val);
        inorder(root.right);

    }

    public int bs(int start, int end, int key){
        int ans = -1;
        while(start<=end){
            int mid = start + ((end-start)>>1);
            int currVal = in.get(mid);

            if(currVal == key){
                return mid;
            }else if(currVal > key){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }

        }
        return ans;
    }


}