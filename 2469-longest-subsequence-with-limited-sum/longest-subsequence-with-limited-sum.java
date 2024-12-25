class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        
        int pre[] = new int[nums.length];
        pre[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            pre[i] = pre[i-1] + nums[i];
        }


        for(int i=0; i<queries.length; i++){
            queries[i] = findUpperBound(pre,queries[i]);
        }
        return queries;
    }

    public int findUpperBound(int nums[], int q){
        int start = 0; 
        int end = nums.length-1;
        int upper = nums.length;
        
        while(start<=end){
            int mid = start +((end - start)>>1);

            if(nums[mid]>q){
                upper = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        
        return upper;
    }
}