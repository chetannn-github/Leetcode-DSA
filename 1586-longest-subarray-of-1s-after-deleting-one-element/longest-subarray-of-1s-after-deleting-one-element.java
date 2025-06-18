// class Solution {
//     public int longestSubarray(int[] nums) {
//         // esi subarray jisme max ek baar zero aaskta hh
//         int start = 0;
//         int zero = 0;
//         int maxLength = 0;
//         int n = nums.length;
        
//         for(int end=0; end<n; end++){
//             if(nums[end]==0){
//                 zero++;
//             }

//             while(zero>1){
//                 if(nums[start]==0){
//                     zero--;
//                 }
//                 start++;
//             }

//             maxLength = Math.max(maxLength, end-start+1 - 1);
//         }

//         return maxLength;
//     }
// }


class Solution {
    public int longestSubarray(int[] nums) {
        // esi subarray jisme max ek baar zero aaskta hh
        int start = 0;
        int ones = 0;
        int maxLength = 0;
        int n = nums.length;
        int maxFreq = 0;
        for(int end=0; end<n; end++){
            if(nums[end]==1){
                ones++;
            }

            maxFreq = Math.max(maxFreq,ones);
            
            while(end - start + 1 > 1 + maxFreq){
                if(nums[start]==1){
                    ones--;
                }
                start++;
            }

            maxLength = Math.max(maxLength, end-start+1 - 1);
        }

        return maxLength;
    }
}