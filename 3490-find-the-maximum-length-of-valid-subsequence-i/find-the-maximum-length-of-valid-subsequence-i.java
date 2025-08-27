class Solution {
    int N;
    public int maximumLength(int[] nums) {
        N = nums.length;
        int ZEROES = 0, ONES = 0;
        for(int i=0; i<N; i++) {
            nums[i] %= 2;
            ZEROES += 1 - nums[i];
            ONES += nums[i];
        }

        /// 1 - 0 - 1 - 0 sequence
        int ONE_ZERO_SEQ = 0;
        int one = -1, zero = 0;
        for(int i=0; i<N; i++) {
            if(one == -1 && nums[i] == 1) {
                ONE_ZERO_SEQ++;
                zero = -1;
                one = 0;
            }else if(zero == -1 && nums[i] == 0) {
                ONE_ZERO_SEQ++;
                one = -1;
                zero = 0;
            }
             
        }

        /// 1 - 0 - 1 - 0 sequence
        int ZERO_ONE_SEQ = 0;
        one = 0; zero = -1;
        for(int i=0; i<N; i++) {
            if(one == -1 && nums[i] == 1) {
                ZERO_ONE_SEQ++;
                zero = -1;
                one = 0;
            }else if(zero == -1 && nums[i] == 0) {
                ZERO_ONE_SEQ++;
                one = -1;
                zero = 0;
            }
             
        }

    

        return Math.max(ONES,Math.max(ZEROES,Math.max(ZERO_ONE_SEQ,ONE_ZERO_SEQ)));


        
    }
}