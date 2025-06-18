class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ones = 0;
       
        int maxLength = 0;
        int start = 0;
        int maxOnes =0;

        for(int end =0; end<n; end++){
            if(nums[end]==1){
                ones++;
            }
            maxOnes = Math.max(ones,maxOnes);

            while(end-start + 1 > maxOnes + k){
                if(nums[start]==1){
                    ones--;
                }
                start++;
            
            }

            maxLength = Math.max(maxLength, end-start+1);
        }

        return maxLength;
    }
}