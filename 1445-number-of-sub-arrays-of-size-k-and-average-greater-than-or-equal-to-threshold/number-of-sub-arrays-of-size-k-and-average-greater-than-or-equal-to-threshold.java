class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int length = nums.length;
        long thresholdSum = k * threshold;
        long sum = 0;

        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        
        int ans = thresholdSum <= sum? 1 : 0;
        

        
        for(int i=k; i<length;i++){
            sum -= nums[i-k];
            sum += nums[i];

            ans += thresholdSum <= sum? 1 : 0;
            
        }
        return ans;
    }
} 
      
   