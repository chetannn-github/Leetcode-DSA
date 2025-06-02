class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];
        int[][] copyIntervals = new int[n][3];
        int idx = 0;
        for (int[] row : intervals) {
            copyIntervals[idx][0] = row[0];
            copyIntervals[idx][1] = row[1];
            copyIntervals[idx][2] = idx++;
        }

        Arrays.sort(copyIntervals,(a,b)->(a[0] - b[0]));
        for (int[] row : copyIntervals) {
            int q = row[1];
            int idxOfAns = row[2];
            int results = bs(copyIntervals, q);

            if (results != -1) ans[idxOfAns++] = copyIntervals[results][2];
            else ans[idxOfAns] = -1;
        }
        return ans;
    }

    public int bs(int[][] nums , int q){
        int start = 0; 
        int end = nums.length-1;
        int ans = -1;

        while(start<=end){
            int mid = start + ((end-start)>>1);
            if(nums[mid][0]>=q){
                ans = mid;
                end = mid -1;
            }else{
                start = mid+1;
            }
        }

        return ans;
    }
}