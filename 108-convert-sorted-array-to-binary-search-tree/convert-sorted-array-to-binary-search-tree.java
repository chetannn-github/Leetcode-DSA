class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums,0,nums.length-1);
    }

    public TreeNode solve(int[] nums,int start, int end){
        if(start>end){
            return null;
        }

        int mid = start + ((end - start) >> 1);

        TreeNode root = new TreeNode(nums[mid]);
        root.left = solve(nums,start,mid-1);
        root.right = solve(nums,mid+1,end);

        return root;
    }
}