class Solution {
    List<TreeNode> ans;
    HashMap<String,Integer> hm;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new ArrayList<>();
        hm = new HashMap<>();
        solve(root);
        return ans;
    }

    public String solve(TreeNode root){
        if(root == null){return new String("N");}
        String s = root.val + " " + solve(root.left) + " " + solve(root.right);

        if(hm.containsKey(s)){
            if(hm.get(s)==1){
                hm.put(s,2);
                ans.add(root);
            }  
        }else{
            hm.put(s,1);
        }
        return s;
    }
}