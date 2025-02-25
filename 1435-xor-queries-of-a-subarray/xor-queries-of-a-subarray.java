class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int xor = 0;

        for(int i = 0; i<arr.length; i++){
            xor ^= arr[i];
            arr[i] = xor;
            
        }
        int[] ans = new int[queries.length];

        for(int i = 0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];

            if(start == 0){
                ans[i] = arr[end];
            }else{
                ans[i] = arr[end] ^ arr[start-1];
            }
        }
        return ans;
    }
}