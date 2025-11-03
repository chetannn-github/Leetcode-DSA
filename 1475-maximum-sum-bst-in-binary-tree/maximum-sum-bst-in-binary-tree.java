// TLE
// class Solution {
//     List<TreeNode> BSTNodes ;
//     HashMap<TreeNode,Integer> subTreeSum = new HashMap<>();
//     public int maxSumBST(TreeNode root) {
//         BSTNodes = new ArrayList<>();
//         dfs(root);
//         int result = 0;
//         for(TreeNode node : BSTNodes){
//             result = Math.max(result,subTreeSum.get(node));
//         }

//         return result;

//     }

//     public int dfs(TreeNode root) {
//         if(root == null) return 0;
//         if(isValidBST(root, -2512,-2512)) {
//             BSTNodes.add(root);
//         }

//         int leftSum = dfs(root.left);
//         int rightSum = dfs(root.right);
//         subTreeSum.put(root, leftSum + rightSum + root.val);
//         return leftSum + rightSum + root.val;
//     }

//     public boolean isValidBST(TreeNode root, int min, int max){
//         if(root == null) return true;
//         if(min != -2512 && root.val <= min){
//             return false;
//         }
//         if(max != -2512 && root.val >= max){
//             return false;
//         }
//         boolean leftResult = isValidBST(root.left,min,root.val);
//         boolean rightResult = isValidBST(root.right,root.val,max);
//         boolean myResult = leftResult && rightResult;
//         return myResult;
//     }

// }


class Solution {
    int MAX = Integer.MAX_VALUE;
    int MIN = Integer.MIN_VALUE;
    public int maxSumBST(TreeNode root) {
        return dfs(root).maxSum;
    }

    public Info dfs(TreeNode root) {
        if(root == null) return new Info(MAX,MIN,0,0);
        
        Info left = dfs(root.left);
        Info right = dfs(root.right);
        
        int sum = left.sum + right.sum + root.val;
        if(root.val > left.max && root.val < right.min) {
            int currMin = Math.min(root.val, left.min);
            int currMax = Math.max(root.val, right.max);
            
            int maxSum = Math.max(sum,Math.max(left.maxSum,right.maxSum));
            return new Info(currMin,currMax,sum,maxSum);
        }

        return new Info(MIN,MAX,sum,Math.max(left.maxSum,right.maxSum));
    }

}

class Info {
    int min,max,sum, maxSum;
    Info(int min, int max, int sum, int maxSum) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.maxSum = maxSum;
    }
}