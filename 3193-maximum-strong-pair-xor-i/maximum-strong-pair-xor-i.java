class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int maxXOR = 0;

        for(int num1 : nums){
            for(int num2 : nums) {
                if(maxXOR < (num1 ^ num2 ) &&  Math.min(num1,num2) >= Math.abs(num1 - num2)){
                    maxXOR = num1 ^ num2;
                }
            }
        }

        return maxXOR;
    }
}