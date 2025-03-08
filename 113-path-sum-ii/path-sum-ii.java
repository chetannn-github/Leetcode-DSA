class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        return solve(root,target,0,temp,result);
    }

    public List<List<Integer>> solve(TreeNode root, int target,int curr,List<Integer> temp,List<List<Integer>> result){
        if(root == null){
            return result;
        }
        if(root.left == null && root.right == null && target == curr + root.val){
            temp.add(root.val);
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return result;
        }

        if(root.left != null){
            temp.add(root.val);
            solve(root.left,target,curr + root.val,temp,result);
            temp.remove(temp.size()-1);
        }

        if(root.right != null){
            temp.add(root.val);
            solve(root.right,target,curr + root.val,temp,result);
            temp.remove(temp.size()-1);
        }
        return result;
    }
}