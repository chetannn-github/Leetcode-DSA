// yhaa phele mere dimaag me yhh aaya tha dp 3d le kuki teen variables change ho rhee hh
    // but start aur occupiedWidth se prr hii depend krr rhii maxHeight kuki hum books sequence me rkh rhee hh
class Solution {
    int n;
    int[][] dp;
    private int NOT_VISITED_FLAG = -2;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        n = books.length;
        dp = new int[n][shelfWidth + 1];
        for(int[] row : dp) Arrays.fill(row,NOT_VISITED_FLAG);
        
        return solve(books,shelfWidth,0,0,0);
    }


    public int solve(int[][] books, int shelfWidth, int currIdx, int currWidth, int currHeight) {
        if(currIdx >= n) return currHeight;
        if(dp[currIdx][currWidth] != NOT_VISITED_FLAG) return dp[currIdx][currWidth];

        int placeInSameRow = Integer.MAX_VALUE;
        int placeInNextRow = Integer.MAX_VALUE;

        int currBookWidth = books[currIdx][0];
        int currBookHeight = books[currIdx][1];

        if(currWidth + currBookWidth <= shelfWidth) {
            placeInSameRow = solve(books,shelfWidth, currIdx +1, currWidth + currBookWidth , Math.max(currHeight, currBookHeight));
        }

        placeInNextRow = currHeight + solve(books,shelfWidth, currIdx +1,currBookWidth ,currBookHeight);

        return dp[currIdx][currWidth] = Math.min(placeInSameRow,placeInNextRow);
    }
}