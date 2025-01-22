class Solution {
    int ans =0;
    int[][] mat ;
    int count =0;
    public int totalNQueens(int n) {
        mat = new int[n][n];
        solve(n,0);
        return ans;
    }

    public void solve(int n, int start){
        if(start==n && count==n){
            ans++;
            return;
        }

        for(int i=start; i<n; i++){
            for(int j=0; j<n; j++){
                if(isSafe(i,j,n)){
                    mat[i][j]=1;
                    count++;
                    solve(n,i+1);
                    mat[i][j]=0;
                    count--;
                }
            }
            if(count != start){
                return;
            }
        }
    }

    public boolean isSafe(int i, int j,int n){
        int row = i-1;
        int col = j-1;
        while(row>=0  && col>=0){
            if(mat[row][col]==1){
                return false;
            }
            row--;
            col--;
        }
        row = i-1;
        col = j;
        while(row>=0  ){
            if(mat[row][col]==1){
                return false;
            }
            row--;
            
        }
        row = i-1;
        col = j+1;
        while(row>=0  && col<n){
            if(mat[row][col]==1){
                return false;
            }
            row--;
            col++;
        }
        return true;
    }

    
}