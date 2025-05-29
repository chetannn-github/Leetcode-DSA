class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int n = nums.length;

        if(n==1 || nums[0]>nums[1]){return 0;}

        if(nums[n-1] > nums[n-2]){return n-1; } 

        int start = 1;
        int end = n-2;
    
        while(start <=end){
            int mid = start + ((end-start) >> 1);

            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) return mid;
            // ascent
            else if ( nums[mid]< nums[mid+1] && nums[mid] > nums[mid-1]) start = mid + 1;
            //descent
            else if (nums[mid] > nums[mid+1] && nums[mid] < nums[mid-1]) end = mid-1;
            // EDGE CASE 2 1 4
            else end = mid-1;
        }
        return -1;
    }
}