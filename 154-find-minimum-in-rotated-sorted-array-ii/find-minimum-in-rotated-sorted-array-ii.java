class Solution {
    public int findMin(int[] nums) {
        int start = 0; 
        int end = nums.length-1;
        int result = Integer.MAX_VALUE;

        while (start <= end){
            int mid = start +((end - start) >> 1);

            if(nums[start] == nums[end]) {
                result = Math.min(result,nums[start]);
                start++;
                end--;
            }else if(nums[start] == nums[mid]) {
                result = Math.min(result,nums[start]);
                start++;
            }else if(nums[start] < nums[end]) {
                result = Math.min(result,nums[start]);
                return result;

            }else if(nums[start]<nums[mid]){
                result = Math.min(result,nums[start]);
                start = mid+1;
                
            }else{
                result = Math.min(result,nums[mid]);
                end = mid -1;
            }
        
    }

        return result;
    }
}