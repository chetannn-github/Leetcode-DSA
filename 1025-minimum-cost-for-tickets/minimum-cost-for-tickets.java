// basic recursion TLE

// class Solution {
//     int minCost = Integer.MAX_VALUE;
//     int n;
//     public int mincostTickets(int[] days, int[] costs) {
//         n = days.length;
//         solve(days,costs,0,0,0);
//         return minCost;
//     }


//     public void solve(int[] days, int[] costs, int start, int cost, int validity){
//         if(start>=n){
//             minCost = Math.min(minCost,cost);
//             return;
//         }

//         if(days[start] <= validity){
//             solve(days, costs, start+1,cost+0, validity);
//         }
//         // choice one  --> one day pass
//         solve(days, costs, start+1,cost+costs[0], days[start]+0);
//         // choice one  --> seven days pass

//         solve(days, costs, start+1,cost+costs[1], days[start]+6);

//         // choice one  --> 30days pass
//         solve(days, costs, start+1,cost+costs[2], days[start]+29);
        
//     }
// }


class Solution {
    int n;
    int dp[];
    public int mincostTickets(int[] days, int[] costs) {
        n = days.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        
        return solve(days,costs,0);
    }


    public int solve(int[] days, int[] costs, int start){
        if(start>=n){
            return 0;
        }
        if(dp[start]!= -1){
            return dp[start];
        }
        
        // choice one  --> one day pass
        int one = costs[0] + solve(days, costs, start+1);


        // choice one  --> seven days pass
        int validity = days[start]+7;
        int j = start;
        while(j<n && days[j]<validity){
            j++;
        }

        int seven = costs[1] + solve(days, costs,j);

        // choice one  --> 30days pass
        validity = days[start]+30;
        j = start;
        while(j<n && days[j]<validity){
            j++;
        }
        int thirty = costs[2] + solve(days, costs,j);


        return dp[start] =  Math.min(Math.min(one,seven),thirty);
        
    }
}