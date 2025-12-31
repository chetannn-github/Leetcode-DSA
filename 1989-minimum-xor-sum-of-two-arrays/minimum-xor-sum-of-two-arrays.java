class Solution {
    int n;
    int[] nums1, nums2;
    HashMap<Integer,Integer>[] dp;
    public int minimumXORSum(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.n = nums1.length;
        this.dp = new HashMap[n];

        for(int i=0; i<n; i++) dp[i] = new HashMap<>();

        return solve(0,0);
    }

    public int solve(int idx, int mask) {
        if(idx == n) return 0;
        if(dp[idx].containsKey(mask)) return dp[idx].get(mask);

        int result = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            if(!isSetBit(mask,i)) {
                int newMask = setBit(mask,i);
                int currResult = (nums1[i] ^ nums2[idx]) +  solve(idx+1,newMask);
                
                result = Math.min(result,currResult);
            }
        }

        dp[idx].put(mask,result);
        return result;

    }

    private boolean isSetBit(int num, int idx) {
        return (num & (1<<idx)) != 0;
    }

    private int setBit(int num, int idx) {
        return  (num | (1<<idx));
    }
}