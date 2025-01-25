class Solution {
    
    int n;
    int dp[];
    int unique[] ;
    HashMap<Integer,Integer> hm = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
     for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + num);
        }

        n = hm.size();
        unique = new int[n];
        int idx = 0;

        for(int key: hm.keySet()){
            unique[idx] = key;
            idx++;
        }

        Arrays.sort(unique);
        dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0);
    }

    public int solve(int start) {
        if (start >= n) {
            return 0;
        }

        if (dp[start] != -1){
            return dp[start];
        }

        int skip = solve(start + 1);

        int currNum = unique[start];
        int take = hm.get(currNum);
        int nextidx = start + 1;

        while (nextidx < n && unique[nextidx] == currNum + 1 ){
            nextidx++;
        }

        take += solve(nextidx);

        return dp[start] = Math.max(skip, take);
    }
}

