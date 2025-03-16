// class Solution {
//     int maxDiff;
//     List<Integer> ancestors;
//     public int maxAncestorDiff(TreeNode root) {
//         maxDiff = 0;
//         ancestors = new ArrayList<>();
//         dfs(root);
//         return maxDiff;
//     }

//     public void dfs(TreeNode root){
//         if(root == null) return ;
//         if(root.left == null && root.right == null) return;

//         ancestors.add(root.val);

//         if(root.left !=null){
//             dfs(root.left);
//             checkDiff(root.left.val);

//         }
//         if(root.right !=null){
//             dfs(root.right);
//             checkDiff(root.right.val);
//         }

//         ancestors.remove(ancestors.size()-1);
//     }

//     public void checkDiff(int child){
//         for(int i=0; i<ancestors.size(); i++){
//             maxDiff = Math.max(maxDiff,Math.abs(child - ancestors.get(i)));
//         }
//     }
// }
class Solution {
    int maxDiff;
    public int maxAncestorDiff(TreeNode root) {
        maxDiff = 0;

        dfs(root,root.val,root.val);
        return maxDiff;
    }

    public void dfs(TreeNode root,int min,int max){
        if(root == null) return ;
        if(root.left == null && root.right == null){
            maxDiff = Math.max(maxDiff,max-min);
            return;
            
        }

        if(root.left !=null) dfs(root.left,Math.min(min,root.left.val),Math.max(max,root.left.val));
        if(root.right !=null) dfs(root.right,Math.min(min,root.right.val),Math.max(max,root.right.val));

    }
}