class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num; 
        }
            
        int count = 0;
        while(xor!=0) {
            if((xor & 1)==1) break;
            count++;
            xor >>= 1;  
        }

        int mask = 1<<count;

        int ans[]={0,0};
        for (int num : nums) {
            if((num & mask)==0) {
                ans[0] ^= num;
            }else{
                ans[1] ^= num;
            }
        }
        return ans;
    }
}