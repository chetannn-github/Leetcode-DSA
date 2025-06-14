class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int m = grid.length,n = grid[0].length;
        int[] arr = new int[m*n];
        int idx = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[idx]= (grid[i][j]);
                idx++;
            }
        }

        Arrays.sort(arr);
        // it is a imp conceptt chetan buddy median ke equal kregee 

        int median = arr[((m*n)/2)];
        int count = 0;

        for(int val : arr){
            int diff = Math.abs(val-median);
            if(diff % x !=0 ){ 
                return -1;
            }
            count += diff / x;   
        }
        return count;
    }
}