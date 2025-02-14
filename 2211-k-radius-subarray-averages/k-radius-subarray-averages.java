class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0){return nums;}
        int n = nums.length;
        int[] ans = new int[n];
        
        if(2*k >=n){
            for(int i= 0; i<n; i++){
                ans[i] = -1;
                
            }
            return ans;
        }
        
        long sum = 0;
        for(int i= 0; i<k; i++){
            ans[i] = -1;
            sum += nums[i];
        }
        for(int i=n-1; i>=n-k;i--){
            ans[i] = -1;
        }

        for(int i=k; i<=2*k; i++){
            sum += nums[i];
        }
        
        int avg =(int) (sum / (2*k+1));
        ans[k] = avg;

        for(int i = k+1; i<=n-k-1; i++){
            sum -= nums[i - k-1];
            sum += nums[i + k];
            avg = (int)(sum / (2*k+1));
            ans[i] = avg;
        }

        return ans;
    }
}