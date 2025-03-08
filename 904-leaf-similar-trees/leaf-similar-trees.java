class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = getLeaves(root1,new ArrayList<>());
        List<Integer> leaves2 = getLeaves(root2,new ArrayList<>());
        int size = leaves1.size();
        return size == leaves2.size() && checkSimilarLeaves(leaves1,leaves2,0,size);
    }

    public List<Integer> getLeaves(TreeNode root,List<Integer> leaves){
        if(root == null){
            return leaves;
        }
        if(root.left == null && root.right == null){
            leaves.add(root.val);
            return leaves;
        }

        if(root.left != null){
            getLeaves(root.left,leaves);
        }

        if(root.right != null){
            getLeaves(root.right,leaves);
        }
        return leaves;
    }

    public boolean checkSimilarLeaves(List<Integer> leaves1, List<Integer> leaves2,int i,int size){
        if(i>=size) return true;

        return leaves1.get(i).equals(leaves2.get(i)) && checkSimilarLeaves(leaves1,leaves2,i+1,size);
    }


}