class Solution {
    // chahe jump krke jaao yaa ese ek ek krkke farak nhii padtaaa  score same aaegaa
    int rows,cols;
    int dp[][];
    public int maxScore(List<List<Integer>> grid) {
        rows = grid.size();
        cols = grid.get(0).size();
        dp = new int[rows][cols];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        } 

        int maxScore = Integer.MIN_VALUE;

        for(int i=0; i<rows;i++){
            for(int j=0; j<cols; j++){
                if(i==rows-1 && j == cols-1) continue;
                maxScore = Math.max(maxScore, solve(grid, i,j));
            }
        }
        return maxScore;
    }


    public int solve(List<List<Integer>> grid , int r , int c){
        if(r == rows-1 && c == cols-1){
            return 0;
        }

        if(dp[r][c]!= -1){
            return dp[r][c];
        }

        // two options hain buddy yaa toh left yaa downn
        int maxScore = Integer.MIN_VALUE;
        int score;


        if(r+1<rows){
            int destinationScore = solve(grid,r+1,c);
            score = grid.get(r+1).get(c)  - grid.get(r).get(c) ;
            score = Math.max(score, score + destinationScore);
            maxScore = Math.max(maxScore, score);
        }

        if(c+1<cols){
            int destinationScore = solve(grid,r,c+1);
            score = grid.get(r).get(c+1)  - grid.get(r).get(c) ;
            score = Math.max(score,score+ destinationScore);
            maxScore = Math.max(maxScore, score);
        }
        
        
        maxScore = maxScore == Integer.MIN_VALUE ? 0 : maxScore ;

        return dp[r][c] = maxScore;
    }
}