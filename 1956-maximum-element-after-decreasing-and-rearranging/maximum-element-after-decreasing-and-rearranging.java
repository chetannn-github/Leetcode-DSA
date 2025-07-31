class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr); 
        int n = arr.length;
        int ops = (arr[0] == 1) ? 0 : 1;
        arr[0] = 1;

        for(int i=1; i<n; i++) {
            if(arr[i] - arr[i-1] > 1) {
                arr[i] = arr[i-1] + 1;
                ops++;
            }
        }

        return arr[n-1];
    }
}