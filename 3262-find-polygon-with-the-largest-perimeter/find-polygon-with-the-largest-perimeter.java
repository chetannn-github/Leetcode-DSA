class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        long[] pre = new long[n];
        Arrays.sort(nums);
        pre[0] = nums[0];

        for(int i=1; i<n; i++) {
            pre[i] = (long) (pre[i-1] + nums[i]);
        }

        for(int i=n-1; i>=2; i--) {
            if(nums[i] < pre[i-1]){
                return pre[i];
            }
        }

        return -1;
    }
}