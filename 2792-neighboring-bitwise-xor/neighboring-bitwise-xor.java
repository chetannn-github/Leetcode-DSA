// class Solution {
//     public boolean doesValidArrayExist(int[] nums) {
//         // ek bar start 0 se krke dekhte hh

//         int first = 0;
//         int next = nums[0];
//         int n = nums.length;

//         if(n==1) return nums[0]==0;

//         for(int i=1; i<n-1;i++){
//             next ^= nums[i];
//         }

//         if((first ^ next) == nums[n-1]){
//             return true;
//         }

//         first = 1;
//         next = 1 ^ nums[0];

//         for(int i=1; i<n-1;i++){
//             next ^= nums[i];
//         }
//         if((first ^ next) == nums[n-1]){
//             return true;
//         }
        
//         return false;
//     }
// }

class Solution {

    public boolean doesValidArrayExist(int[] derived) {
        int XOR = 0;
        for (int element : derived) {
            XOR = XOR ^ element;
        }
        return XOR == 0;
    }
}