class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        long sum = 0;

        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        double avg = (double) sum/k;

        long temp = sum;
        for(int i=k; i<length;i++){
            sum -= nums[i-k];
            sum += nums[i];

            avg = Math.max((double) sum/k,avg);
            
        }
        return avg;
    }
} 
    