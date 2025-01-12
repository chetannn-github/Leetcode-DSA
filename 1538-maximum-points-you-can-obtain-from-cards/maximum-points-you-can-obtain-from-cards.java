class Solution {
    public int maxScore(int[] nums, int k) {
        int length = nums.length;
        int sum = 0;

        // shuru ke kk elements ka sum
        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        

        int temp = sum;
        for(int i=length-1; i>=length-k;i--){
            temp -= nums[k-1 - (length-1  - i)];
            temp += nums[i];
            
            sum = Math.max(temp,sum); 
            
            
            
        }
        return sum;  
    }
}