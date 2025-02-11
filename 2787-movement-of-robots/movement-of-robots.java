import java.util.Arrays;

class Solution {
    int mod = 1_000_000_007;

    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] pos = new long[n];
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                pos[i] = d + (long) nums[i];
            } else {
                pos[i] =(long) nums[i] - d; 
            }
        }
        
        Arrays.sort(pos);
        long ans = 0;
        long prefixSum = 0;

        for (int i = 0; i < n; i++) {
            ans = (ans + (pos[i] * i )- prefixSum)%mod;
            prefixSum = (prefixSum + pos[i] )%mod;
        }

        return (int) ans;
    }
}
