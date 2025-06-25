class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;

        int start = 0;
        int n = nums.length;
        int subarrays = 0;
        long prod = 1;

        for(int end =0; end<n; end++){
            prod *= nums[end];

            while(prod>=k){
                prod /= nums[start];
                start++;
            }

            subarrays += end-start+1;
            
        }

        return subarrays;
    }
}