// whyyy this fails because wo toh hamesha optimally khelegaa
// tumm yhha greedly dekh rhe ho har step prrr 
// optimally mtlab overalll win
// so whenever options comes recursion comes in the picturee......

// class Solution {
//     public boolean predictTheWinner(int[] nums) {
        
//         int start =0;
//         int end = nums.length-1;

//         int count = 0;
//         boolean first = true;
//         int p1 = 0;

//         while(count<nums.length){
//             if(first && nums[start]<=nums[end]){
//                 p1 += nums[end];
//                 end--;
//                 first = !first;
//             }else if(first && nums[start]>nums[end]){
//                 p1 +=  nums[start];
//                 start++;
//                 first = !first;
//             }else if(!first && nums[start]<=nums[end]){
//                 p1 -= nums[end];
//                 end--;
//                 first = !first;
//             }else if(!first && nums[start]>nums[end]){
//                 p1 -=  nums[start];
//                 start++;
//                 first = !first;
//             }
//             count++;
//         }

//         return p1>=0;
//     }
// }



class Solution {
    public boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int p1 = solve(nums, 0, nums.length-1);
        int p2 = sum - p1;
        return p1>=p2;
    }

    public int solve(int[] nums, int start , int end){
        if(start>end){
            return 0;
        }
        if(start == end){
            return nums[end];
        }

        int option1 = nums[start] + Math.min(solve(nums,start+2,end), solve(nums,start+1,end-1));
        int option2 = nums[end] + Math.min(solve(nums,start+1,end-1), solve(nums,start,end-2));

        return Math.max(option1 , option2);
    }
}



