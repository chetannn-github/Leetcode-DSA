class Solution {
    public int longestSubarray(int[] nums) {
        int maxLength = 1;
        int n = nums.length;
        int maxVal = nums[0];
        int idx = 0;

        for(int i = 0; i<n; i++) {
            if(nums[i]>maxVal) {
                maxVal = nums[i];
                idx = i;
            }
        }

        // ab mera kaam simple hh maxVal hoo continuously uski maxLength btanii h
        int start = idx;
        int maxFreq = 0;

        for(int end = idx; end < n; end++) {
            if(nums[end] == maxVal) {
                maxFreq++;
            }

            while(end - start + 1 > maxFreq) {
                if(nums[start] == maxVal) {
                    maxFreq--;
                }
                start++;
            }
            maxLength = Math.max(end - start + 1, maxLength);
        }
        return maxLength;

    }
}