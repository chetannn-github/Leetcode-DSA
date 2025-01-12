class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int length = nums.length;
        long sum = 0;

        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        int avg =(int)sum/k;
        int ans = avg>=threshold ? 1 : 0;
        

        
        for(int i=k; i<length;i++){
            sum -= nums[i-k];
            sum += nums[i];

            avg = (int)sum/k;
            ans += avg>=threshold ? 1 : 0;
            
        }
        return ans;
    }
} 
      
   