class Solution {
    public int hIndex(int[] nums) {
        int start = 0;
        int end = nums.length;
        Arrays.sort(nums);
         

        for(int i=nums.length; i>=0; i--){
            int biggerCount = nums.length - findUpperBound(nums,i);

            if(biggerCount >=i){
                return i;
            }
        }
        return 0;
    }


    public int findUpperBound(int[] nums , int q){
        int start = 0; 
        int end = nums.length-1;
        int upper = nums.length;
        while(start<=end){
            int mid = start + ((end-start)>>1);
            if(nums[mid]>=q){
                upper = mid;
                end = mid -1;
            }else{
                start = mid+1;
            }
        }

        return upper;
    }
}