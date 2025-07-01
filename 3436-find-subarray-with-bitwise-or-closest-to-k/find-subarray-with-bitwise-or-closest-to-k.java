class Solution {
    int[] freq; 
    int cumOR;
    int start ;
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        // if(n == 1) return Math.abs(k - nums[0]);

        int minDiff = Integer.MAX_VALUE;
        freq = new int[31];
        cumOR = 0; start = 0;

        for(int end = 0; end<n; end++){
            cumOR |= nums[end];
            updateBitsFreq(nums[end]);

            while(cumOR >= k){
                minDiff = Math.min(Math.abs(cumOR - k), minDiff);
                if(minDiff == 0) return 0;
                removeStartAndUpdateORAndBitsFreq(nums[start]);
            }
            // kukii uparr wala loop me agr element k se badaa huaa tohh sare eleements haata dega window se toh cumOR = 0 hojaaegaa isliye mene yhh condn start < = end lagaii hh
            if(start <= end) minDiff = Math.min(Math.abs(cumOR - k), minDiff);
            if(minDiff == 0) return 0;
        }
        return minDiff == Integer.MAX_VALUE ? -1 : minDiff;
    }

    private void updateBitsFreq(int num) {
        for(int i=0; i<32 && num > 0; i++) {
            int bit = (num & 1);
            freq[i] += bit;
            num >>= 1;
        }
    }

    private void removeStartAndUpdateORAndBitsFreq (int num) {
        start++;
        for (int i=0; i<32 && num>0; i++) {
            int bit = (num & 1);
            freq[i] -= bit;
            num >>= 1;

            if(freq[i] == 0) {
                cumOR &=(~(1<< i));
            }
        }
    }
    
}