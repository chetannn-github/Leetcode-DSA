class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[][] dist = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dist[i][j] = Math.abs(i-j);
            }
        }
        if(x != y ){
            dist[x-1][y-1] = 1;
            dist[y-1][x-1] = 1;
        }
        


        for(int via = 0; via <n; via++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][via] + dist[via][j] < dist[i][j]){
                        dist[i][j] = dist[i][via] + dist[via][j];
                    }
                }
            }
        }

        int ans[] = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dist[i][j] == 0) continue;
                ans[dist[i][j]-1]++;
            }
        }

        return ans;
    }
}