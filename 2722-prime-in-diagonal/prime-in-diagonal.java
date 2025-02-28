class Solution {
    public int diagonalPrime(int[][] nums) {
        int ans = 0;
        for(int i=0;i<nums.length; i++){
            if(nums[i][i] >ans && isPrime(nums[i][i])){
                ans = nums[i][i];
            }
            if(nums[i][nums.length-1-i] > ans && isPrime(nums[i][nums.length-1-i])){
                ans = nums[i][nums.length-1-i];
            }
        }
        return ans;
    }

    public boolean isPrime(int num){
        if(num == 1){
            return false;
        }
        for(int i=2; i <= Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}