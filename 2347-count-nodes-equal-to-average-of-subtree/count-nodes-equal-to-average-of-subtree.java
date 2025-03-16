class Solution {
    int count;
    public int averageOfSubtree(TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }

    public List<Integer> dfs(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        if(root.left == null && root.right == null){
            ans.add(root.val);
            ans.add(1);
            count++;
            return ans;
        }
        List<Integer> left = dfs(root.left);
        List<Integer> right = dfs(root.right);
    
        int sum = 0;
        int members = 0;

        if(left.size()==0){
            members = right.get(1) + 1;
            sum =  right.get(0) + root.val;
        }else if(right.size() ==0){
            members = left.get(1) + 1;
            sum = left.get(0) + root.val ;
        }else{
            members = left.get(1) + right.get(1) + 1;
            sum = left.get(0) + right.get(0) + root.val ;
        }

    
        if((sum/members) == root.val) count++;

        ans.add(sum);
        ans.add(members);

        return ans;

    }
}