class Solution {
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        long sum =0;
        for(int i=0; i<candies.length; i++){
            sum += candies[i];
        }
        int start = 1;
        int end =(int)( sum/k);
        int ans = 0;
        while(start<=end){
            int mid = start + ((end-start)>>1);
            if(k <= checkPossible(candies,mid)){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }

    public long checkPossible(int[] nums , int q){
        long child = 0;
        for(int i=0; i<nums.length; i++){
            child += nums[i]/q;
        }
    
        return child;
    }
}