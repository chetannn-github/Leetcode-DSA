class Solution {
    public int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int n = pos.length;
        int start = 1, end = pos[n-1] - pos[0];
        int result = 1;

        while(start <= end) {
            int mid = start + ((end-start)>>1);

            if(isPossible(pos,mid,m)) {
                result = mid;
                start = mid+1;
            }else end = mid-1;
        }
        return result;
    }

    private boolean isPossible(int[] arr, int target, int total) {
        int placed = 1;
        int prevPlacedIdx = 0;


        for(int i=1; i<arr.length; i++) {
            if(arr[i] - arr[prevPlacedIdx] >= target) {
                prevPlacedIdx = i;
                placed++;
            }

            if(placed == total) return true;
        }

        return false;
    }



}