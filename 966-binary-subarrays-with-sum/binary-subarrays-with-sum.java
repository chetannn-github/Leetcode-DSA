// class Solution {
//     public int numSubarraysWithSum(int[] nums, int k) {
//            int ans= 0;
//         int sum =0;
//         HashMap<Integer,Integer> hm = new HashMap();
//         hm.put(0,1);
//         for(int i=0; i<nums.length; i++){
//            sum +=nums[i];
//             if(hm.containsKey(sum-k)){
//                 ans +=hm.get(sum-k);
//             }
//             hm.put(sum,hm.getOrDefault(sum,0)+1);
//         }
        
     
//         return ans;
//     }
// }

class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {

        return helper(nums,k) - helper(nums,k-1);
        
    }
    public int helper(int[] nums, int k){
        if(k<0){return 0;}

        int start = 0;
        int n = nums.length;
        int subarrays = 0;
        int sum = 0;

        for(int end =0; end<n; end++){
            sum += nums[end];

            while(sum>k){
                sum -= nums[start];
                start++;
            }

            subarrays += end-start+1;
            
        }

        return subarrays;
    }
}