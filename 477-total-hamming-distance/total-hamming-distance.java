// class Solution {
//     public int totalHammingDistance(int[] nums) {
//         int ans = 0;
//         int n = nums.length;
//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 ans  += hammingDistance(nums[i],nums[j]);
//             }
//         }
//         return ans;
//     }
    
//     public int hammingDistance(int x, int y) {
//         int ans = 0;
//         if(x == y){
//             return 0;
//         }
//         while(x!=0 || y!=0){
//             ans += (x&1 )^ (y&1);
//             y>>=1;
//             x>>=1;
//        } 
//        return ans;
//     }
// }


class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i=0; i<32; i++){
            int countOnes = 0;
            for(int j=0; j<n;j++){
                countOnes += ( 1 & (nums[j]>>i));
            }
    
            ans += (countOnes * (n - countOnes));
        }
        return ans;
    }
    
}