class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int currWindowNegativeCount = 0;
        int[] freq = new int[51];

        for(int i=0; i<k; i++) {
            if(nums[i] < 0)  freq[-nums[i]]++;
            currWindowNegativeCount += nums[i]<0 ? 1: 0;
        }

        
        for(int i=k; i<=n;i++) {
            
            if(currWindowNegativeCount>=x) {
                int cumFreq = 0;
                for(int j=50; j>0; j--) {
                    cumFreq += freq[j];

                    if(cumFreq >= x) {
                        result[i-k] = -j;
                        break;
                    }
                }
            }else{
                result[i-k] = 0;
            }

            if (i==n) break;
            
            currWindowNegativeCount += nums[i-k] < 0 ? -1: 0;
            currWindowNegativeCount += nums[i] < 0 ? 1: 0;

            if (nums[i] < 0 ) freq[-nums[i]]++;
            if (nums[i-k] < 0 ) freq[-nums[i-k]]--;

        }
        
        return result;
    }
}    
  