class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        // answer lies in between 0 to length
        int start = 0;
        int end = nums.length;
        // while(start<=end){
        //     int mid = start + ((end-start)>>1);
        //     int biggerCount = nums.length - findUpperBound(nums,mid);

        //     if(biggerCount == mid){
        //         return mid;
        //     }else if(biggerCount<mid){
        //         start = mid+1;
        //     }else{
        //         end = mid-1;
        //     }
        // }

        for(int i=0; i<nums.length+1; i++){
              int biggerCount = nums.length - findUpperBound(nums,i);

              if(biggerCount ==i){
                return i;
              }
        }
        return -1;
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