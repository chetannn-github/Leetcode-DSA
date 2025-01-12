class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        long sum = 0;

        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        

        long temp = sum;
        for(int i=k; i<length;i++){
            temp -= nums[i-k];
            temp += nums[i];

            sum = Math.max(temp,sum);
            
        }
        return (double) sum/k;
    }
} 
    