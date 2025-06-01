class Solution {
    public int maxValue(int n, int index, int maxSum) {
        // i assumed  arr to be intially all one
        int start = 2;
        int end = maxSum;
        int ans = 1;

        while(start <= end) {
            int mid = start + ((end - start) >> 1);

            if(isPossible(n,index,maxSum, mid)) {
                start = mid + 1;
                ans = mid;
            }else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int n, int index, int maxSum, int maxOfIndex) {
        int left = Math.min (index, maxOfIndex - 2);
        int right = Math.min (n-1-index, maxOfIndex -2);

        long leftSum = ((long) (left)  * ((maxOfIndex - 2)*2 + 1 - left) )/2;
        long rightSum = ((long) (right)  * ((maxOfIndex - 2)*2 + 1 - right ))/2;
        long totalIncreasedVal = leftSum + rightSum + maxOfIndex - 1;

        return maxSum >= n + totalIncreasedVal;
    }
}