class Solution {
    int[] chargeTimes,runningCosts;
    long[] prefixSum;
    long budget;
    int n;
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        this.chargeTimes = chargeTimes;
        this.runningCosts = runningCosts;
        this.budget = budget;
        this.prefixSum = buildPrefixSumArray(runningCosts);
        this.n = chargeTimes.length;

        int start = 0;
        int end = n; 
        int result = 0;

        while(start <= end) {
            int mid = start + ((end-start) >> 1);

            if(isPossible(mid)) {
                result = mid;
                start = mid+1;
            }else end = mid-1;
        }

        return result;
    }


    private boolean isPossible(int k) {
        int[] slidingWindowMax = getSlidingWindowMax(chargeTimes,k);

        for(int i=0; i<n-k+1; i++) {
            long windowSum = prefixSum[i+k] - prefixSum[i];
            long cost = slidingWindowMax[i] + windowSum * k ;

            if(cost <= budget) return true;
        }

        return false;
    }


    private int[] getSlidingWindowMax(int[] arr ,int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;
        int[] slidingWindowMax = new int[n-k+1];

        for(int i=0; i<n; i++) {
            while(!dq.isEmpty() && dq.peekFirst() <= i-k) dq.removeFirst();
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) dq.removeLast();

            dq.addLast(i);

            if(i>=k-1) slidingWindowMax[i-k+1] = arr[dq.peekFirst()];
        }

        return slidingWindowMax;
    }

    private long[] buildPrefixSumArray(int[] arr) {
        int n = arr.length;
        long[] prefixSum = new long[n+1];

        for(int i=0; i<n; i++) {
            prefixSum[i+1] = prefixSum[i] + arr[i]; 
        }
        return prefixSum;
    } 


}