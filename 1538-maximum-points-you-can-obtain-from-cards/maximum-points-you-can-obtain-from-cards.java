class Solution {
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        // shuru ke kk elements ka sum
        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        if(k == nums.length) return sum;
        
        int temp = sum;
        for(int i=n-1; i>=n-k;i--){
            temp -= nums[k-1 - (n-1  - i)];
            temp += nums[i];
            
            sum = Math.max(temp,sum); 
        }
        return sum;  
    }
}