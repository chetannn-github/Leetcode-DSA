class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int start = 0;
        int cumOR = 0;
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        for(int end = 0; end<n; end++){
            cumOR |= nums[end];
            
            if(cumOR>=k){
                minLength = Math.min(minLength, end - start +1);
                if(minLength==1) return 1;
                int tempOR = 0;
                int BaadMeKaamAegaOR= 0;
                for(int i = end; i>=start; i--){
                    tempOR |= nums[i];
                    if(tempOR>=k){
                        minLength = Math.min(minLength, end - i +1);
                        if(minLength==1) return 1;
                        start = i+1;
                        cumOR = BaadMeKaamAegaOR;
                        break;
                    }
                    BaadMeKaamAegaOR |= nums[i];
                }
            }
        
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}