class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        

        for(int i=1; i<nums.length; i++){
            nums[i] = nums[i-1] + nums[i];
        }

        for(int i=0; i<queries.length; i++){
            queries[i] = findUpperBound(nums,queries[i]);
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