class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int freeTimes[] = new int[n+1];
        int prevEndTime = 0;

        for(int i=0; i<n; i++) {
            freeTimes[i] = startTime[i] - prevEndTime;
            prevEndTime = endTime[i];
        }
        freeTimes[n] = eventTime - prevEndTime;

        int m = n+1;
        int[] leftMaxFreeTime = new int[n+1];
        int[] rightMaxFreeTime = new int[n+1];

        int leftMax = Math.max(freeTimes[0], freeTimes[1]);
        int rightMax = 0; 

        for (int i = m - 2; i >= 0; i--) {
            rightMaxFreeTime[i] = Math.max(rightMaxFreeTime[i + 1], freeTimes[i + 1]);
        }
    
        for (int i = 1; i < m; i++) {
            leftMaxFreeTime[i] = Math.max(leftMaxFreeTime[i - 1], freeTimes[i - 1]);
        }

        

        int maxFree = 0;

        for(int i=1; i<n+1; i++) {
            int maxFreeTimeSideWise = Math.max(leftMaxFreeTime[i-1], rightMaxFreeTime[i] );
            int currMeetingDuration = endTime[i-1] - startTime[i-1];

            if(maxFreeTimeSideWise >= currMeetingDuration ) {
                maxFree = Math.max(maxFree,currMeetingDuration + freeTimes[i] +  freeTimes[i-1]);
            }else maxFree = Math.max(maxFree,freeTimes[i] +  freeTimes[i-1]);

        }

        return maxFree;

       


        
    }


    
}