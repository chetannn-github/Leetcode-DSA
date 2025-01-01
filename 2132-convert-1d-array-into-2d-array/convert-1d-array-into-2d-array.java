class Solution {
    public int[][] construct2DArray(int[] og, int m, int n) {
        // if(m*n != og.length){
        //     return new int[][]{};
        // }
        // int [][] ans = new int[m][n];
        // int count = 0;
        // for(int i=0; i<m; i++){
        //     int[] row = new int[n];

        //     for(int j=0; j<n; j++){
        //         row[j] = og[count];
        //         count++;
        //     }
        //     ans[i] = row;
        // }
        // return ans;


         // //OPTIMIZED 
    // // If dimensions are invalid, return an empty 2D array
        if (og.length != m * n) return new int[0][0];
        
        int[][] res = new int[m][n];
        for (int i = 0; i < og.length; i++) {
            res[i / n][i % n] = og[i];
        }
        
        return res;


    }
}