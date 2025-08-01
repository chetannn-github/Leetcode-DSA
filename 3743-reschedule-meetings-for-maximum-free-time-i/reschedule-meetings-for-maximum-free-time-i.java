class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int freeTimes[] = new int[n+1];
        int prevEndTime = 0;

        for(int i=0; i<n; i++) {
            freeTimes[i] = startTime[i] - prevEndTime;
            prevEndTime = endTime[i];
        }
        freeTimes[n] = eventTime - prevEndTime;

        // i all want to find k+1 size sliding maxsum
        return findMaxWindowSum(freeTimes,k+1);
    }


    public int findMaxWindowSum(int[] arr, int windowSize) {
        int n = arr.length;
        int windowSum = 0;

        for(int i=0; i<windowSize; i++) {
            windowSum += arr[i];
        }
        int maxWindowSum = windowSum;

        for(int i=windowSize; i<n; i++) {
            windowSum += arr[i] - arr[i-windowSize];
            maxWindowSum = Math.max(maxWindowSum,windowSum);
        }

        return maxWindowSum;
    }
}