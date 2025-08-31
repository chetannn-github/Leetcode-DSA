class Solution {
    int prev ,curr, maxFreq, currFreq;
    List<Integer> ans;
    public int[] findMode(TreeNode root) {
        ans = new ArrayList<>();
        maxFreq = 1;

        prev = Integer.MAX_VALUE;
        currFreq = 1;
        inorder(root);

        maxFreq = Math.max(currFreq,maxFreq);
        
        
        prev = Integer.MAX_VALUE;
        currFreq = 1;
        inorderModified(root);
        
        int size = ans.size();
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = ans.get(i);
        }
        return arr;
    

    }

    public void inorder(TreeNode root){
        if(root == null) return ;
        inorder(root.left);

        curr = root.val;
        if(curr == prev){
            currFreq++;
        }else if(curr != prev){
            maxFreq = Math.max(currFreq,maxFreq);
            currFreq = 1;
        }
        prev = curr;

        inorder(root.right);
    }

    public void inorderModified(TreeNode root){
        if(root == null) return ;

        inorderModified(root.left);
        curr = root.val;
        if(maxFreq == 1){
            ans.add(curr);
        }else if(curr == prev){
            currFreq++;
            if(currFreq == maxFreq){
                ans.add(curr);
            }
        }else if(curr != prev){
            currFreq = 1;
        }
        prev = curr;

        inorderModified(root.right);
    }
}