class Solution {
    public int longestSubarray(int[] nums) {
        
        int maxLength = 1;
        int n = nums.length;
        
        int maxVal = nums[0];
        int idx = 0;

        for(int i = 0; i<n; i++){
            if(nums[i]>maxVal){
                maxVal = nums[i];
                idx = i;
            }
            
        }

        // ab mera kaam simple hh maxVal hoo continuously uski maxLength btanii h
        int start = idx;
        int end = idx;
        while(end<n){

            while(end <n && nums[end] == maxVal){
                end++;
            }

            maxLength = Math.max(maxLength,end-start);

            start = end;

            while(start < n && nums[start] != maxVal){
                start++;
            }
            end = start;
        }

        return maxLength;

    }
}