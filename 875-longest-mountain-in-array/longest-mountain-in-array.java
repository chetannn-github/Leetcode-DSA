class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int result = 0;
        if(n < 3) return result;
        
        int peak = -1;
        int valley = arr[0] < arr[1] ? 0 : n;


        for(int i=1; i<n-1; i++) {
            if(arr[i-1] > arr[i] && arr[i] <= arr[i+1]) {
                result = peak != -1 ? Math.max(result,i - valley + 1) : result;
                valley = i;
            }else if(arr[i-1] == arr[i]) {
                valley = i;
            }


            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
                peak = i;
            }
        }

        if(arr[n-1] < arr[n-2]) {
            result = peak != -1 ? Math.max(result,n-1- valley + 1) : result;
        }

        return result < 3 ? 0 : result;
    }
}