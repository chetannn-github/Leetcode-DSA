class Solution {
    public int minOperations(int[] nums, int k) {
        // calculate xor of each element of array 
        int xor =0;
        for(int i=0; i<nums.length;i++){
            xor ^= nums[i];
        }

        xor ^=k;

        // finally xor me kitne 1 hain utna hii ans hojaaegaa
        int count =0;
        while(xor!=0){
            count += (xor&1);
            xor = xor>>1;
        }

        return count;


    }
}