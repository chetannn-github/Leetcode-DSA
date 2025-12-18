class Solution {
    public int findMinimumTime(int[][] tasks) {
        int[] onTime = new int[2001];
        Arrays.sort(tasks,(a,b)->(a[1]-b[1]));

        for(int[] task : tasks) {
            int duration = task[2];
            int start = task[0];
            int end = task[1];

            for(int i=start; i<=end; i++) {
                if(onTime[i] == 1) duration--;
            }

            for(int i= end; i>= start && duration > 0; i--) {
                if(onTime[i] != 1) {
                    onTime[i] = 1;
                    duration--;
                }
            }
        }


        int totalOnTime = 0;

        for(int i=0; i<onTime.length; i++) {
            totalOnTime += onTime[i];
        }

        return totalOnTime;
    }
}