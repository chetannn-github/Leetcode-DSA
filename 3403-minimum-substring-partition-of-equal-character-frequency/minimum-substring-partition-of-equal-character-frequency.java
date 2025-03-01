class Solution {
    int n;
    int[] dp;
    public int minimumSubstringsInPartition(String s) {
        n = s.length();
        dp = new int[n];
        Arrays.fill(dp,-1);
       
        return  solve(s,0);
    }

    public int solve(String s,int start){
        if(start>=n){
            return 0;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        int[] freq = new int[26];
        int min = Integer.MAX_VALUE;
        for(int i=start; i<n; i++){
            freq[s.charAt(i) - 'a']++;

            if(checkPartitionPossible(s,freq,freq[s.charAt(i) - 'a'])){
                int next = solve(s,i+1);
                if(next != Integer.MAX_VALUE){
                    min = Math.min(min, 1 + next);
                } 
            }
        }
        return dp[start] =  min;
    }


    public boolean checkPartitionPossible(String s, int[] freq, int check){
        
        for(int i=0; i<26; i++){
            if(freq[i]!=0 && freq[i] != check){
                return false;
            }
        }
        return true;
    }
}