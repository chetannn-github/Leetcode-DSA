class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start = 0;
        int n = nums.length;
        int maxLength = 1;

        for(int end = 1; end<n; end++){
            // sbse ensure krnaa padegaa jb tum nyaa member jod rhoo hoo toh sbhii
            // doston se puchoo are you finee????
            // end se puchna shuru krugaa jisme mna kiyaa usse aur usse phele waalo se dosti khtmm

            for(int i = end-1; i>=start; i--){
                if((nums[i] & nums[end] )!= 0){
                    start = i+1;
                    break;
                }
            }
            

            maxLength = Math.max(maxLength, end-start+1);
        }

        return maxLength;
    }
}


// class Solution {
    // public int longestNiceSubarray(int[] nums) {
    //     int start = 0;
    //     int n = nums.length;
    //     int maxLength = 1;

    //     for(int end = 1; end<n; end++){
    //         int i = start;
    //         while(i<end){
    //             if((nums[i++] & nums[end] )!= 0){
    //                 start = i;
    //             }
    //         }
            

    //         maxLength = Math.max(maxLength, end-start+1);
    //     }

    //     return maxLength;
    // }
// }