class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        ArrayList<Integer> diag = new ArrayList<>();

        for(int i=0; i<mat.length; i++){
            int row = i;
            int col = 0;
            while(row<r && col<c){
                diag.add(mat[row][col]);
                row++;
                col++;
            }

            Collections.sort(diag);

            row = i;
            col = 0;
            int idx = 0;
            while(row<r && col<c){
                mat[row][col]= diag.get(idx);
                row++;
                col++;
                idx++;
            }
            diag.clear();
        }
        for(int i=1; i<mat[0].length; i++){
            int row = 0;
            int col = i;
            while(row<r && col<c){
                diag.add(mat[row][col]);
                row++;
                col++;
            }

            Collections.sort(diag);

            row = 0;
            col = i;
            int idx = 0;
            while(row<r && col<c){
                mat[row][col]= diag.get(idx);
                row++;
                col++;
                idx++;
            }
            diag.clear();
        }

        return mat;
    }
}