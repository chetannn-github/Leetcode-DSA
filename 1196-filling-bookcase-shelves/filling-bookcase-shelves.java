class Solution {
    // yhaa phele mere dimaag me yhh aaya tha dp 3d le kuki teen variables change ho rhee hh
    // but start aur occupiedWidth se prr hii depend krr rhii maxHeight kuki hum books sequence me rkh rhee hh
    int n;
    int dp[][];
    public int minHeightShelves(int[][] books, int shelfWidth) {
        n = books.length;
        dp = new int[n][shelfWidth+1];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(books,shelfWidth, 0,0,0);
    }

    public int solve(int[][] books, int shelfWidth, int start, int occupiedWidth, int maxHeight){

        if(start>=n){
            return maxHeight ;
        }

        if(dp[start][occupiedWidth]!=-1){
            return dp[start][occupiedWidth];
        }

        int currWidth = books[start][0];
        int currHeight = books[start][1];

        int opt1 = Integer.MAX_VALUE;
        if(currWidth + occupiedWidth <= shelfWidth){
            opt1 = solve(books, shelfWidth,start+1, currWidth + occupiedWidth, Math.max(maxHeight,currHeight));
        }

        int opt2 = maxHeight + solve(books,shelfWidth,start+1, currWidth, currHeight);

        return dp[start][occupiedWidth] = Math.min(opt1,opt2);
    }
}