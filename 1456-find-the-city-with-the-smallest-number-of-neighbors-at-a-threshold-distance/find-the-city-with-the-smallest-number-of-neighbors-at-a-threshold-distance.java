class Solution {
    public int findTheCity(int n, int[][] edges, int distMax) {
        int[][] dist = new int[n][n];

        for(int[] row : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        for(int[] edge : edges){
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        for(int via =0; via<n; via++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i == j){ 
                        dist[i][j] = 0;
                        continue;
                    }
                    if(dist[i][via] != Integer.MAX_VALUE && dist[via][j] != Integer.MAX_VALUE){
                        if(dist[i][via] + dist[via][j] < dist[i][j]){
                            dist[i][j] = dist[i][via] + dist[via][j];
                        }
                    }
                }
            }
        }
        int minCount = n;
        int ans = 0;

        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(i != j && dist[i][j] <= distMax) count++;
                // System.out.print(dist[i][j] + " -> ");
            }
            // System.out.println();
            if(minCount >= count){
                minCount = count;
                ans = i;
            }
        }

        return ans;
    }
}