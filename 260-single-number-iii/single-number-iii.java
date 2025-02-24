class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums){
            xor ^= num; 
        }
            
        int count = 0;
        while(xor!=0){
            if((xor & 1)==1){break;}
            count++;
            xor >>= 1;  
        }

        int rightMost = 1<<count;

        // int rightMost = xor&-xor; 
        // int rightMost = (xor &(xor-1))^xor;

        int ans[]={0,0};
        for (int num : nums){
            if((num&rightMost)==0){
                ans[0] ^= num;
            }
            else{
                ans[1] ^= num;
            }
        }
        return ans;
    }
}