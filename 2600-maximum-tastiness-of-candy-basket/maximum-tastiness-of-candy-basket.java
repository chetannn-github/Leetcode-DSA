class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int start = 0, end = price[n-1] - price[0];
        int result = 0;
        
        while(start <= end) {
            int mid = start + ((end-start)>>1);

            if(canPlace(mid,price,k)) {
                result = mid;
                start = mid+1;
            }else end = mid-1;
        }

        return result;
    }

    private boolean canPlace(int target, int[] arr, int k) {
        int placed = 1;
        int prevPlacedIdx = 0;

        for(int i=1; i<arr.length; i++) {
            if(arr[i] - arr[prevPlacedIdx] >= target) {
                placed++;
                prevPlacedIdx = i;
            }

            if(placed == k) return true;
        }
        return false;
    }
}