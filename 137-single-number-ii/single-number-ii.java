class Solution {
    // public int singleNumber(int[] nums) {
    
    //     Arrays.sort(nums);

    //     for (int i = 1; i<nums.length;){
    //         if(nums[i]!= nums[i-1]){
    //             return nums[i-1];
    //         }
    //         i+=3;
    //     }

    //     return nums[nums.length-1];
    // }


    public int singleNumber(int[] nums) {
        int ans =0;
        for(int i = 0; i<=31;i++){
            int count = 0;
            for(int j = 0; j<=nums.length-1;j++){
                count += (1 & (nums[j]>>i)) ; 
            }
            if(count%3==1){
                // set i th bit of ans
                ans = ans | (1<<i);
            }
        }   
        return ans;
    }


  
    
}