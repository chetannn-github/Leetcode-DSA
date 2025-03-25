class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int cumXOR = 0;

        for(int i=0; i<rows; i++){
            for(int j=1; j<cols; j++){
                matrix[i][j] ^= matrix[i][j-1]; 
            }
        }
        for(int i=1; i<rows; i++){
            for(int j=0; j<cols; j++){
                matrix[i][j] ^= matrix[i-1][j]; 
            }
        }


        for(int[] row : matrix){
            for(int xor : row){
                pq.add(xor);
                if(pq.size() > k) pq.remove();
            }
        }


        return pq.peek();
        
    }
}