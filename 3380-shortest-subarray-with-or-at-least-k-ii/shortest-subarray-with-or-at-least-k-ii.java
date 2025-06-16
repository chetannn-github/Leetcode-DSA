// class Solution {
//     public int minimumSubarrayLength(int[] nums, int k) {
//         int start = 0;
//         int cumOR = 0;
//         int n = nums.length;
//         int minLength = Integer.MAX_VALUE;

//         for(int end = 0; end<n; end++){
//             cumOR |= nums[end];
            
//             if(cumOR >= k){
//                 minLength = Math.min(minLength, end - start +1);
//                 if(minLength==1) return 1;

//                 int tempOR = 0;
//                 int BaadMeKaamAegaOR= 0;
                
//                 for(int i = end; i>=start; i--){
//                     tempOR |= nums[i];
//                     if(tempOR>=k) {
//                         minLength = Math.min(minLength, end - i +1);
//                         if(minLength==1) return 1;
//                         start = i+1;
//                         cumOR = BaadMeKaamAegaOR;
//                         break;
//                     }
//                     BaadMeKaamAegaOR |= nums[i];
//                 }
//             }
        
//         }

//         return minLength == Integer.MAX_VALUE ? -1 : minLength;
//     }
// }

class Solution {
    int[] freq; 
    int cumOR;
    int start ;
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        freq = new int[31];
        cumOR = 0; start = 0;

        for(int end = 0; end<n; end++){
            cumOR |= nums[end];
            updateBitsFreq(nums[end]);

            while(cumOR >= k){
                minLength = Math.min(end - start + 1 , minLength);
                if(minLength == 1) return 1;
                removeStartAndUpdateXORAndBitsFreq(nums[start]);
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public void updateBitsFreq(int num) {
        for(int i=0; i<32 && num > 0; i++) {
            int bit = (num & 1);
            freq[i] += bit;
            num >>= 1;
        }
    }

    public void removeStartAndUpdateXORAndBitsFreq (int num) {
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