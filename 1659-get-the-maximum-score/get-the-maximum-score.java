class Solution { 
    HashMap<Integer,Integer> firstLookup = new HashMap<>();
    HashMap<Integer,Integer> secondLookup = new HashMap<>();
    int n1, n2;
    int[] nums1, nums2;
    int MOD = 1_000_000_007;
    Long[][] dp;

    public int maxSum(int[] nums1, int[] nums2) {
        this.n1 = nums1.length; 
        this.n2 = nums2.length;
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.dp = new Long[Math.max(n1, n2)][2];

        for(int i = 0; i < n1; i++) {
            firstLookup.put(nums1[i], i);
        }

        for(int i = 0; i < n2; i++) {
            secondLookup.put(nums2[i], i);
        }

        long result = Math.max(solve(0, 0), solve(0, 1));
        return (int)(result % MOD);
    }

    private long solve(int currIdx, int isFirst) {
        if(isFirst == 1 && currIdx >= n1) return 0;
        if(isFirst == 0 && currIdx >= n2) return 0; 
        if(dp[currIdx][isFirst] != null) return dp[currIdx][isFirst];

        long score = 0;

        if(isFirst == 1) {
            int curr = nums1[currIdx];
            
            long stayScore = curr + solve(currIdx + 1, isFirst);
            score = Math.max(score, stayScore);

            if(secondLookup.containsKey(curr)) {
                long switchScore = curr + solve(secondLookup.get(curr) + 1, 0);
                score = Math.max(score, switchScore);
            }

        } else {
            int curr = nums2[currIdx];
            
            long stayScore = curr + solve(currIdx + 1, isFirst);
            score = Math.max(score, stayScore);

            if(firstLookup.containsKey(curr)) {
                long switchScore = curr + solve(firstLookup.get(curr) + 1, 1);
                score = Math.max(score, switchScore);
            }
        }

        return dp[currIdx][isFirst] = score;
    }
}