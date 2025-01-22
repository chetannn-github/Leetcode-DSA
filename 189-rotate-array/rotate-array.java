
// 1. Recursion TLE

// class Solution {
//     public void rotate(int[] nums, int k) {
//         k = k % nums.length;

//         if(k==0){
//             return;
//         }
//         int last = nums[nums.length-1];

//         for(int i=nums.length-1;i>0; i--){
//             nums[i] = nums[i-1];
//         }
//         nums[0] = last;

//         rotate(nums,k-1);
//         return;
//     }
// }



class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        int temp[] = new int[k];
        for(int i= 0; i<k; i++){
            temp[i] = nums[n -k +i];
        }

        for(int i = n-k-1 ; i>=0; i--){
            nums [i+k] = nums[i]; 
        }

        for(int i=0; i<k; i++){
            nums[i] = temp[i];
        }
        
    }
}