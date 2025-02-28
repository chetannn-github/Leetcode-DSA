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

        for(int j=1;j<n; j++){
            for(int k = j+1; k<n; k++){
                maxLength  = Math.max(2 + solve(j, k, arr),maxLength);
            }
        }
        return maxLength == 2 ? 0 : maxLength;
    }


    public int solve(int j,int k, int[] arr){
        
        if(dp[j][k]!=-1){
            return dp[j][k];
        }
        int prev = arr[k] - arr[j];
        if(hm.containsKey(prev) && hm.get(prev)<j){
            return 1 + solve(hm.get(prev),j ,arr);
        } 

        return dp[j][k] = 0;
    }
}