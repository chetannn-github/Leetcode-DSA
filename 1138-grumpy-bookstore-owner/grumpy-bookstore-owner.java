class Solution {
    public int maxSatisfied(int[] customers, int[] nums, int k) {
        int n = nums.length;
        
        int start = 0;
        int max = 0;
        int cust = 0;

        for( int i=0; i<n; i++){
            if(nums[i]==0){
                cust += customers[i];
            }
        }

        for(int end = 0; end<n; end++){
            if(nums[end]==1){
                cust += customers[end];
            }
            
            if(end - start +1 > k){
                if(nums[start] == 1){
                    cust -= customers[start];
                }
                start++;
            }
            max = Math.max(cust,max);
        }

        return max;
    }
}