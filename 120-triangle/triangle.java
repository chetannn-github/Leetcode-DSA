class Solution {
    int r;
    int dp[][];
    public int minimumTotal(List<List<Integer>> matrix) {
        r = matrix.size();
        dp = new int[r][r];

        for(int[] row : dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        return solve(matrix,0,0) ;
    }

    public int solve(List<List<Integer>> matrix,int i, int j){
        int c = i+2; // agli wali row ke liyee

        if(i==r-1){
            return matrix.get(i).get(j);
        }

        if(dp[i][j] != Integer.MAX_VALUE ){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        
        // row+1,c (down)
        if(i+1<r){
            int opt2 = matrix.get(i).get(j) + solve(matrix,i+1,j);
            ans = Math.min(ans,opt2);
        }
        // row+1, col+1(right diagonal)
        if(i+1<r && j+1<c){
            int opt3 = matrix.get(i).get(j) + solve(matrix,i+1,j+1);
            ans = Math.min(ans,opt3);
        }

        return  dp[i][j] = ans;
    }
}