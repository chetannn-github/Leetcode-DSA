class Solution {
    HashMap<Integer,Integer> hm;
    int n;
    int dp[][];
    public int lenLongestFibSubseq(int[] arr) {
        int maxLength = 0;
        n = arr.length;
        dp = new int[n][n];

        hm = new HashMap<>();
        for(int i = 0; i<n; i++){
            hm.put(arr[i],i);
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<n; i++){
            for(int j = i+1; j<n; j++){
                maxLength  = Math.max(2 + solve(i, j, arr),maxLength);
            }
        }
        return maxLength == 2 ? 0 : maxLength;
    }


    public int solve(int first,int second, int[] arr){
        

        if(dp[first][second]!=-1){
            return dp[first][second];
        }
        int next = arr[first] + arr[second];
        if(hm.containsKey(next)){
            return 1 + solve(second, hm.get(next),arr);
        } 

        return dp[first][second] = 0;
    }
}