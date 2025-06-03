class Solution {
    int m,n;
    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;

        int start = 0;
        int end = Math.min(m,n);
        int max = 0;

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

                for(int p=0; p<side && sum <= threshold; p++) {
                    for(int q=0; q<side && sum <= threshold; q++) {
                        sum += mat[i+p][j+q];
                    }
                }

                if(sum <= threshold) return true;
            }
        }

        return false;
    }
}