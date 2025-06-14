class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rowMinMax = Integer.MIN_VALUE;

        for(int[] row : matrix){
            int rowMin = Integer.MAX_VALUE;
            for(int num : row){
                rowMin = Math.min(rowMin, num);
            }
            rowMinMax = Math.max(rowMinMax,rowMin);
        }
        int colMaxMin = Integer.MAX_VALUE;

        for(int j=0; j<matrix[0].length; j++){
            int colMax = Integer.MIN_VALUE;
            for(int i=0; i<matrix.length; i++){
                colMax = Math.max(colMax, matrix[i][j]);
            }
            colMaxMin = Math.min(colMaxMin,colMax);
        }
        List<Integer> ans = new ArrayList<>();
        if(colMaxMin == rowMinMax){
            ans.add(colMaxMin);
        }
        
        return ans;
    }
}