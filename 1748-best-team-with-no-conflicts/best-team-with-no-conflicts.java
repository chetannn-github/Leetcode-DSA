class Solution {
    int data[][];
    int n; 
    int[][] dp;
    public int bestTeamScore(int[] scores, int[] ages) {
        n = scores.length;
        data = new int[n][2];
        dp = new int[n][n];

        
        for(int i=0;i<n;i++){
            data[i][0] = ages[i];
            data[i][1] = scores[i];
            Arrays.fill(dp[i], -1);
        }

        Arrays.sort(data, (a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

        return solve(-1,0);
    }

    public int solve(int lastIdx, int start){
        if(start>=n){
            return 0;
        }

        int take = 0;
        int score = data[start][1];
        int age = data[start][0];

        if(lastIdx!= -1 && dp[lastIdx][start] != -1){
            return dp[lastIdx][start];
        }

        if(lastIdx != -1){
            int lastScore = data[lastIdx][1];
            int lastAge = data[lastIdx][0];
            int lastIdxForNextCall = score > lastScore ? start : lastIdx;

            if(lastAge==age){
                take = score + solve( lastIdxForNextCall, start+1);
            }else if(score >= lastScore){
                take = score + solve(start , start+1);
            }
        }else{
            take = score + solve(start , start+1);
        }
        
        int skip = solve(lastIdx,start+1);

        if(lastIdx!= -1){
            dp[lastIdx][start] = Math.max(take,skip);
        }
        return Math.max(take,skip);
    }
}