class Solution {
    int[] freq;
    int ans ;
    public int pseudoPalindromicPaths (TreeNode root) {
        freq = new int[9];
        ans = 0;
        freq[root.val-1]++;
        dfs(root);
        
        return ans;
    }


    public void dfs(TreeNode root){
        if(root.left == null && root.right == null){
            //check is it pseudo palindromic
            checkPseudoPalindromic(freq);
            return;
        }
       
        
        if(root.left != null ) {freq[root.left.val -1]++; dfs(root.left);freq[root.left.val -1]--;}
        if(root.right != null ) {freq[root.right.val -1]++; dfs(root.right);freq[root.right.val -1]--;}
        

        return ;
    }

    public void checkPseudoPalindromic(int[] freq){
        boolean oneOdd = false;

        for(int occ : freq){
            if(occ%2!=0){
                if(!oneOdd) oneOdd = true;
                else return ;
            }
        }
        ans++;
        return ;
    }
}