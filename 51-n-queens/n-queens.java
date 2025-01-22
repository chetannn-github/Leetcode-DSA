class Solution {
    List<int[][]> results = new ArrayList<>();
    int[][] mat ;
    int count =0;
    public List<List<String>> solveNQueens(int n) {
        mat = new int[n][n];
        solve(n,0);
        List<List<String>> ans = new ArrayList<>();
        
        for(int k=0; k<results.size(); k++){
            int[][] temp = results.get(k);
            List<String> solution = new ArrayList<>();

            for(int i=0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<n; j++){
                    if(temp[i][j]==1){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                solution.add(sb.toString());
            }
            ans.add(solution);
        }
        
        return ans;
    }

    public void solve(int n, int start){
        if(start==n && count==n){
            int[][] copy = deepCopyMatrix(mat);
            results.add(copy);
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

    public static int[][] deepCopyMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
           for(int j=0; j<cols; j++){
            copy[i][j] = matrix[i][j]; 
           }
        }
        return copy;
    }
}