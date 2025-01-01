class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        int count = 0;
        int n = matrix[0].length;

        for(int[] r : matrix ){
            for(int el : r){
                if(el==0){
                    row.add(count/n);
                    col.add(count%n);
                    
                }count++;
            }
        }


        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(row.contains(i)){
                    matrix[i][j] = 0;
                }else if(col.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }

        return;
        
    }
}