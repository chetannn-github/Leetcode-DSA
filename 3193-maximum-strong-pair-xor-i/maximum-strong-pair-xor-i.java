class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int maxXOR = 0;

        for(int num1 : nums){
            for(int num2 : nums) {
                if(Math.min(num1,num2) >= Math.abs(num1 - num2)){
                    maxXOR = Math.max(maxXOR, num1 ^ num2);
                }
            }
        }

        return maxXOR;
    }
}