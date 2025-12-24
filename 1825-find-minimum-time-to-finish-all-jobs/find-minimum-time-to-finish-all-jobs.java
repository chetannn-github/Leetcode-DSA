class Solution {
    int[] workers, jobs;
    int k,n;
    int minVal = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        this.k = k;
        this.n = jobs.length;
        this.jobs = jobs;
        this.workers = new int[k];

        Arrays.sort(jobs);
        reverse(jobs);
        solve(0);
        return minVal;
    }


    private void solve(int currIdx) {
        if(currIdx >= n) {
            minVal = Math.min(minVal,getMaxVal(workers));
            return;
        }
        
        for(int i=0; i<k; i++) {
            if(i>0 && workers[i-1] == workers[i]) continue;
            if(workers[i] + jobs[currIdx] > minVal) continue;

            workers[i] += jobs[currIdx];
            solve(currIdx+1);
            workers[i] -= jobs[currIdx];

            if(workers[i] == 0) break;
        }
    }


    private int getMaxVal(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for(int num : nums) maxVal = Math.max(maxVal,num);
        return maxVal;
    }

    private void reverse(int[] arr) {
        int start = 0, end = arr.length - 1;
        while(start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}

