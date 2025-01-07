class Solution {
    public int maxSum(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] pre = new int[rows][cols];

        // row wise prefix sum
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(j==0){
                    pre[i][j]= mat[i][j];
                }else{
                    pre[i][j] = pre[i][j-1] + mat[i][j];
                }
            }
        }
        //col wise prefix sum
        for(int i=1; i<rows; i++){
            for(int j=0; j<cols; j++){
                pre[i][j] += pre[i-1][j] ;
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i=1; i<rows-1; i++){
            
            for(int j=1;j<cols-1; j++){
                int tempANS = - mat[i][j-1] -  mat[i][j+1];
        
                int r1 = i-1;
                int c1= j-1;

                int r2 = i+1;
                int c2 = j+1;

                tempANS +=sumRegion(pre, r1,  c1,  r2,  c2);
                maxSum = Math.max(tempANS, maxSum);
                
            }
           
        }

        return maxSum;
    }

     public int sumRegion(int[][] mat, int r1, int c1, int r2, int c2) {
        long ans = mat[r2][c2];

        if(r1>0){ans -= mat[r1-1][c2];}
        if(c1>0){ans -= mat[r2][c1-1];}
        if(r1>0 && c1>0){ans += mat[r1-1][c1-1];}

        return (int) (ans); 
    }
}