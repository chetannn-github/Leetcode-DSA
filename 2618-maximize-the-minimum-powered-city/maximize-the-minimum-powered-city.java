class Solution {
    public long maxPower(int[] stations, int r, int k) {
        long result = 0L;
        long start = (long) findMinimum(stations);
        long end = findTotalSum(stations) + k;
        
        while(start <= end) {
            long mid = start + ((end-start)>>1);

            if(isPossible(stations,mid,r,k)) {
                result = mid;
                start = mid+1;
            }else end = mid-1;
        }

        return result;
    }

    private boolean isPossible(int[] arr, long target, int r, int k) {
        int n = arr.length;
        long[] copy = getArrayCopy(arr);

        long windowSum = 0L;
        for(int i=0; i<=r; i++) windowSum += copy[i];

        int start = 0;
        int end = r;
        boolean lastAdded = false;
        for(int curr=0; curr<n; curr++) {
            if(curr-r > start) {
                windowSum -= copy[start++];
            }
 
            if(windowSum < target) {
                long diff = target-windowSum;
                copy[end] += diff;
                k -= diff;
                windowSum += diff;

                if(k < 0) return false;
            }
            
            end = Math.min(n-1,end+1);
            windowSum += (end < n) && !lastAdded ? copy[end] : 0;

            if(end == n-1) lastAdded = true;
        }

        return true;
    }


    private long findTotalSum (int[] nums) {
        long totalSum = 0L;
        for(int num : nums) totalSum += num;
        return totalSum;
    }

    private long[] getArrayCopy(int[] arr) {
        int n = arr.length;
        long[] copy = new long[n];
        for(int i=0; i<n; i++) copy[i] = (long) arr[i];

        return copy;
    }

    private int findMinimum(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        for(int num : nums) minVal = Math.min(minVal,num);
        return minVal;
    }
}