// 



class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start = 0;
        int n = nums.length;
        int maxLength = 1;

        for(int end = 1; end<n; end++){
            int i = start;
            while(i<end){
                if((nums[i++] & nums[end] )!= 0){
                    start = i;
                }
            }
        
            maxLength = Math.max(maxLength, end-start+1);
        }

        return maxLength;
    }
}