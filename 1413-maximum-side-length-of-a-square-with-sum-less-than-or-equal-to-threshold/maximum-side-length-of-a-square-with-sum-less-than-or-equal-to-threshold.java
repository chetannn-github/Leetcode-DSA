class Solution {
    int m,n;
    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;

        int start = 0;
        int end = Math.min(m,n);
        int max = 0;

        for(int i=0; i<m; i++) {
            for(int j=1; j<n; j++) {
                mat[i][j] += mat[i][j-1];
            }
        }
        
        
        for(int i=1; i<m; i++) {
            for(int j=0; j<n; j++) {
                mat[i][j] += mat[i-1][j];
            }
        }

        while(start <= end) {
            int mid = start + ((end - start) >> 1);

            if(checkPossible(mat,mid, threshold)) {
                max = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return max;
    }

    public boolean checkPossible(int[][] mat, int side, int threshold) {
        if (side == 0) return true;

        for(int i=0; i <= m-1-(side - 1); i++) {
            for(int j=0; j <= n-1-(side - 1); j++) {
                int sum = 0;
                int bottomRightX = i + side -1;
                int bottomRightY = j + side -1;

                int topRightX = i;
                int topRightY = j + side -1;

                int bottomLeftX = i + side -1;
                int bottomLeftY = j;


                if(i - 1 >= 0) {
                    sum -= mat[i-1][topRightY];

                    
                }
                if(j-1 >=0) {
                    sum -= mat[bottomLeftX][j - 1];
                }

                if(i-1 >= 0 && j-1>=0) {
                    sum += mat[i-1][j-1];
                }

                sum += mat[bottomRightX][bottomRightY];

                if(sum <= threshold) return true;
                
            }
        }

        return false;
    }
}