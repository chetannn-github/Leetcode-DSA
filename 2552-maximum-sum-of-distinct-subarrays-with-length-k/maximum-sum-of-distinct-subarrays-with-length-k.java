class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int length = nums.length;
        long sum = 0;
        long ans = 0;

        for(int i=0; i<k; i++){
            sum += nums[i];
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        
        if(hm.size()==k){
            ans = sum;
        }
        
        for(int i=k; i<length;i++){

            sum -= nums[i-k];
            sum += nums[i];
            // delete last one 
            if(hm.get(nums[i-k])==1){
                hm.remove(nums[i-k]);
            }else{
                hm.put(nums[i-k], hm.get(nums[i-k])-1);
            }
            
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);

            if(hm.size()==k){
                ans = Math.max(ans,sum);
            }
            
        }
        return ans;
    }
} 