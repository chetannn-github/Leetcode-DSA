class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        for(int[] t : trust){
            indegree[t[1]-1]++;
            outdegree[t[0]-1]++;
        }
        
        int ans = -1;
        for(int i=0; i<n; i++){
            if(indegree[i] == n-1 && outdegree[i] == 0){
                if(ans == -1) ans = i+1;
                else{
                    return -1;
                }
            }
        }

        return ans;
    }
}