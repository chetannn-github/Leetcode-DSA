// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
//         // answer lies between 1 to length so we can think about binary search
//         int start = 1; 
//         int end = nums.length;
//         int ans = 0;
//         for(int i=1; i<nums.length; i++){
//             nums[i] +=nums[i-1];
//         }

//         while(start<=end){
//             int mid = start + ((end-start)>>1);
           
//             if(isPossible(target, nums, mid)){
//                 end = mid-1;
//                 ans = mid;
//             }else{
//                 start = mid+1;
//             }
//         }
//         return ans;
//     }

//     public Boolean isPossible(int target, int[] nums , int size){
//         // phele prefix sum nikal lete hh easy padegaa 
//         // desired length ke subarray ka sum nikalne ke liye 
//         // nhii toh baar traverse krna padegaa
       
//         if(target<=nums[size-1]){
//             return true;
//         }
//         for(int j=0, i=size; i<nums.length; i++){
//             if(target<= nums[i]-nums[j] ){
//                 return true;
//             }
//             j++;
//         }
//         return false;
//     }
// }



class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0; 
        int currSum = 0;
        int minLength = Integer.MAX_VALUE; 

        for (int end = 0; end < n; end++) {
            
            currSum += nums[end];

            
            while (currSum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                currSum -= nums[start];
                start++;
                if(minLength ==1){return 1;}
            }
        }


        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    
}