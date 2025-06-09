class NumMatrix {
    long [][] copy;
    public NumMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        copy = new long[rows][cols];

        // row wise prefix sum
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(j==0){
                    copy[i][j]= mat[i][j];
                }else{
                    copy[i][j] = copy[i][j-1] + mat[i][j];
                }
            }
        }
        //col wise prefix sum
        for(int i=1; i<rows; i++){
            for(int j=0; j<cols; j++){
                copy[i][j] += copy[i-1][j] ;
            }
        }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        long ans = copy[r2][c2];

        if (r1>0) ans -= copy[r1-1][c2];
        if (c1>0) ans -= copy[r2][c1-1];
        if (r1>0 && c1>0) ans += copy[r1-1][c1-1];

        return (int) (ans); 
    }
}
