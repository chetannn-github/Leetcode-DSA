// class Solution {
//     public int numSubarrayBoundedMax(int[] nums, int left, int right) {
//         // right se bade wale nikal lo aur left se bade wale nikal krr subtract krr do!!
       
//         return countSubarraysWithMax(nums,left) - countSubarraysWithMax( nums, right+1);
//     }

//     public int countSubarraysWithMax(int[] nums, int limit) {
        
//         int start = 0;
//         int subarrays = 0;
//         int n = nums.length;


//         for(int end = 0; end<n; end++){

//             if(nums[end]>=limit){
//                 subarrays += (end-start+1) * (n - end);
//                 start = end+1;
//             }


//         }

//         return subarrays;
//     }
// }

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // right se chote wale nikal lo aur left se chote wale nikal krr subtract krr do!!
       
        return countSubarraysWithMin(nums,right) - countSubarraysWithMin( nums, left-1);
    }

    public int countSubarraysWithMin(int[] nums, int limit) {
        int start = 0;
        int subarrays = 0;
        int n = nums.length;


        for(int end = 0; end<n; end++){

            while(end<n && nums[end]>limit){
                start = ++end;
            }
            if(end<n && nums[end]<=limit){
                subarrays += end - start + 1;
            }
        }

        return subarrays;
    }
}