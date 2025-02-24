// class Solution {
//     public int missingNumber(int[] nums) {
//         int missing = nums.length;
//         for (int i=0;i<nums.length;i++){
//             missing = missing+i-nums[i];
//         }
//         return missing;

//     }
// }


//  method 2 using xor instead of add as a^a = 0


  
class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i=0;i<nums.length;i++){
            missing ^= nums[i] ^ i;
        }
        return missing;

    }
}
