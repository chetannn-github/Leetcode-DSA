class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] ans = new int[mat.length][mat[0].length];

         // row wise prefix sum
        for(int i=0; i<rows; i++){
            for(int j=1; j<cols; j++){
                mat[i][j] += mat[i][j-1];
                
            }
        }
        //col wise prefix sum
        for(int i=1; i<rows; i++){
            for(int j=0; j<cols; j++){
                mat[i][j] += mat[i-1][j] ;
            }
        }

        for(int i=0; i<ans.length; i++){
            for(int j=0; j<ans[0].length; j++){
                int r1 = Math.max(0, i-k) ;
                int c1 = Math.max(0, j-k) ;

                int r2 =Math.min(mat.length-1 , i+k) ; 
                int c2 = Math.min(mat[0].length-1 , j+k) ; 
                ans[i][j] = sumRegion(mat, r1,  c1,  r2,  c2);
            }
        }

        return ans;
    }

    public int sumRegion(int[][] pre,int r1, int c1, int r2, int c2) {
        long ans = pre[r2][c2];

        if (r1>0) ans -= pre[r1-1][c2];
        if (c1>0) ans -= pre[r2][c1-1];
        if (r1>0 && c1>0) ans += pre[r1-1][c1-1];

        return (int) (ans); 
    }
}