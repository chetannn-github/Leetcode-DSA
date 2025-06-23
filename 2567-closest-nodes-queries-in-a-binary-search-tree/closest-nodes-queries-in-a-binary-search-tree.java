class Solution {
    // it is more like upper bound and lower bound in binary search
    List<Integer> in;
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = queries.size();
        in = new ArrayList<>();
        inorder(root);
        int size = in.size();

        for(int i=0; i<n; i++){
            int q = queries.get(i);
            ans.add(bs(0,size-1,q,-1,-1));
        }
        return ans;
        
    }

    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        in.add(root.val);
        inorder(root.right);

    }

    public List<Integer> bs(int start, int end, int key, int max, int min){
        int ans = -1;

        while (start<=end) {
            int mid = start + ((end-start)>>1);
            int currVal = in.get(mid);

            if(currVal == key){
                return List.of(key,key);
            }else if(currVal > key){
                max = max == -1 ? currVal : Math.min(max, currVal);   
                end = mid-1;
            }else{
                min = min == -1 ? currVal : Math.max(min, currVal);
                start = mid+1;
            }
        }
        return List.of(min,max);
    }
}

//tle --> firstly mujhe lag rhaa thaa yhh binary search hii toh hain but it depend on 
// the shape of binary search tree tb kbhii kbhii O(n) bhii hojaaegaa
// class Solution {
//     public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
//         List<List<Integer>> results = new ArrayList<>();
//         int n = queries.size();

//         for(int i=0; i<n; i++){
//             int q = queries.get(i);
//             results.add(inorder(root,-1,-1,q));
//         }

//         return results;
        
//     }

//     public List<Integer> inorder(TreeNode root, int min, int max, int q){
//         if(root == null) return List.of(min, max);

//         if(root.val > q ) {
//             max = max == -1 ? root.val : Math.min(max, root.val);
//             return inorder(root.left, min, max, q);
            
//         }else if(root.val < q ){
//             min = min == -1 ? root.val : Math.max(min, root.val);
//             return inorder(root.right, min, max, q);
//         }else {
//             min = root.val; 
//             max = root.val;
//         }
//         return List.of(min, max);
        

//     }
// }