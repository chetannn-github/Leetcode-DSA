class Solution {
    double oneFourth = 0.25;
    double[][] dp;
    double NOT_VISITED_FLAG = -1.0;
    public double soupServings(int n) {
        if(n>5000) return 1.0;
        int servings = (int) Math.ceil((double) n / 25);
        System.out.println(servings);

        dp = new double[servings+1][servings+1];
        for(double[] row : dp) Arrays.fill(row, NOT_VISITED_FLAG);

        return solve(servings, servings);
    }

    public double solve(int a, int b) {
        if(a<=0 && b<=0) return 0.5;
        if(b<=0) return 0.0;
        if(a<=0 && b>0) return 1;
        
        if(dp[a][b] !=  NOT_VISITED_FLAG) return dp[a][b];
       

        double opt1 = oneFourth * solve(a-4,b);
        double opt2 = oneFourth * solve(a-3,b-1);
        double opt3 = oneFourth * solve(a-2,b-2);
        double opt4 = oneFourth * solve(a-1,b-3);


        return dp[a][b] = opt1 + opt2 + opt3 + opt4;


    }
}