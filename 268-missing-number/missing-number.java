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


  
// class Solution {
//     public int missingNumber(int[] nums) {
//         int missing = nums.length;
//         for (int i=0;i<nums.length;i++){
//             missing ^= nums[i] ^ i;
//         }
//         return missing;

//     }
// }


// method 3 if numbers are from 0 to n then cyclic sort

class Solution {
    public int missingNumber(int[] nums) {
        int start = 0;
        int n = nums.length;

        while(start<n){
            if(nums[start] == n){
                start++;
            }else if( nums[start] != start){
                // swap  b/w nums[start] index and start index
                int idx = nums[start];
                nums[start] ^= nums[idx];
                nums[idx] ^= nums[start];
                nums[start] ^= nums[idx];
            }else{
                start++;
            }
        }


        for(int i=0; i<n; i++){
            if(nums[i]!= i){
                return i;
            }
        }

        return n;

    }
}

