class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> ans = new ArrayList<>();
        int length = nums.length;
        long[] pre = new long[length+1];
        Arrays.sort(nums);
        

        for(int i=0; i<length;i++){
           pre[i+1] = nums[i] + pre[i];
        }

        for(int i=0; i<queries.length; i++){
            // find upper bound
            int upper = findUpperBound(nums,queries[i]);
            long leftOps = (upper) * (long)queries[i] - pre[upper];
            long rightOps = (pre[length] - pre[upper]) - (long)(length - upper) * queries[i];
            long op = leftOps + rightOps;
            ans.add(op);
        }



        return ans;
    }


    public int findUpperBound(int[] nums , int q){
        int start = 0; 
        int end = nums.length-1;
        int upper = nums.length;
        while(start<=end){
            int mid = start + ((end-start)>>1);
            if(nums[mid]>q){
                upper = mid;
                end = mid -1;
            }else{
                start = mid+1;
            }
        }

        return upper;
    }

    
}