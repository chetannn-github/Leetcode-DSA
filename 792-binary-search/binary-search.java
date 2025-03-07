// class Solution {
//     public int search(int[] nums, int target) {
//         int start = 0;
//         int end = nums.length-1;

//         while(end >= start){
//             int mid = start + ((end - start)>>1) ;

//             if(nums[mid] == target){
//                 return mid;
//             }else if(nums[mid] > target){
//                 end = mid - 1;
//             }else{
//                 start = mid + 1;
//             }

//         }

//         return -1;
//     }
// }

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        return binarySearch(nums,target, start, end);
    }


    public int binarySearch(int[] nums, int target,int start,int end){
        int mid = start + ((end - start)>>1) ;

        if(start>end) return -1;

        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] > target){
           return binarySearch(nums,target,start,mid-1);
        }
        return binarySearch(nums,target,mid+1,end);
    
    
    }

        
}