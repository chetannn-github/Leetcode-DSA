class Solution {
    List<Integer> result = new ArrayList<>();
    int n,k,subarraySumLength;
    int[] subarraySum;
    Integer[][] dp;
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        this.n = nums.length; 
        this.k = k;
        this.subarraySum = buildSlidingWindow(nums,n,k);
        this.subarraySumLength = subarraySum.length;
        this.dp = new Integer[subarraySumLength][3];

        for(int i=0; i<subarraySumLength; ) {
            int takenCount = result.size();
            if(takenCount == 3) break;
            int take = subarraySum[i] + solve(i+k,takenCount+1);
            int skip = solve(i+1,takenCount);

            if(take >= skip) {
                result.add(i);
                i += k;
            }else i++;
        }
        
        return toArray(result);
    }


    private int solve(int start, int takenCount) {
        if(takenCount == 3) return 0;
        if(start >= subarraySumLength) return Integer.MIN_VALUE;
        if(dp[start][takenCount] != null) return dp[start][takenCount];

        int take = subarraySum[start] + solve(start+k,takenCount+1);
        int skip = solve(start+1,takenCount);

        return dp[start][takenCount] = Math.max(take, skip);

    }


    private int[] buildSlidingWindow(int[] nums, int n, int k) {
        int[] subarraySum = new int[n-k+1];
        int windowSum = 0;
        for(int i=0; i<k; i++)  windowSum += nums[i];

        for(int i=k; i<n; i++) {
            subarraySum[i-k] = windowSum;
            windowSum += nums[i] - nums[i-k];
        }
        subarraySum[n-k] = windowSum;
        return subarraySum;
    }


    private int[] toArray(List<Integer> list) {
        int n = list.size();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }    
}