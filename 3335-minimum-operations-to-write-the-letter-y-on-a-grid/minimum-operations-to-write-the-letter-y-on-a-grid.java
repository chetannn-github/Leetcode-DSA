class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int[] nonY = new int[3];
        int[] Y = new int[3];

        for(int i=0; i<n; i++){
            int temp = Integer.MAX_VALUE;
            for(int j=0; j<n; j++){
                if(i<=n/2 && (i==j || j == n-i-1)){
                    Y[grid[i][j]]++;
                }else if(i>n/2 && j==n/2){
                    Y[grid[i][j]]++;
                }else{
                    nonY[grid[i][j]]++;
                }
            }
        }

        

        int ans = n*n;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==j){continue;}
                int temp = n*n - Y[i]  - nonY[j];
                 ans = Math.min(ans,temp);
            }
           
        }
        return ans;
    }
}