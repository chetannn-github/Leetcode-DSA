class Solution {
    String word;
    int n;
    Integer[][][] dp;
    public int minimumDistance(String word) {
        this.word = word;
        this.n = word.length();
        dp = new Integer[n][27][27];
        return solve(0,26,26);
    }

    private int solve(int currIdx, int first, int second ) {
        if(currIdx == n) return 0;
        if(dp[currIdx][first][second] != null) return dp[currIdx][first][second];

        int currChar = (int) (word.charAt(currIdx) - 'A');
        int[] cord = findCordinate(currChar);
        int[] firstCord = findCordinate(first);
        int[] secondCord = findCordinate(second);

        int firstDistance = first == 26 ? 0 : Math.abs(cord[0] - firstCord[0]) + Math.abs(cord[1] - firstCord[1]);
        int secondDistance = second == 26 ? 0 :  Math.abs(cord[0] - secondCord[0]) + Math.abs(cord[1] - secondCord[1]);

        int useFirst = firstDistance + solve(currIdx+1,currChar, second);
        int useSecond = secondDistance + solve(currIdx+1,first,currChar);
        
        return dp[currIdx][first][second] = Math.min(useFirst, useSecond);

    }

    private int[] findCordinate(int ch) {
        
        int x = ch / 6;
        int y = ch % 6;
        return new int[] {x,y};
    }
}