class Solution {
    public int maxPossibleScore(int[] arr, int d) {
        Arrays.sort(arr);
        int n = arr.length;
        long start = 0, end = arr[n-1] + d - arr[0] + 0L;
        long result = 0;
        
        while(start <= end) {
            long mid = start + ((end-start)>>1);

            if(canPlace(mid,arr,n,d)) {
                result = mid;
                start = mid+1;
            }else end = mid-1;
        }

        return (int) result;
    }

    private boolean canPlace(long target, int[] arr, int n,int d) {
        long lastPlaced = arr[0];

        for (int i=1; i<n; i++) {
            long nextOne = Math.max(arr[i], lastPlaced + target);
            if(nextOne > arr[i] + d) {
                return false;
            }

            lastPlaced = nextOne;
        }
        return true;
    }
}