// tle
// class Solution {
//     public long countFairPairs(int[] nums, int lower, int upper) {
//         Arrays.sort(nums);
//         int start = 0; 
//         int end = nums.length-1;
        
//         int count = 0;

//         for(int i = start; i<=end ; i++) {
//             for(int j = i+1; j<=end; j++) {
//                 int sum = nums[i] + nums[j];
//                 if(sum >= lower && sum <= upper){
//                     count++;
//                 }else if(sum > upper) {
//                     break;
//                 }
//             }
//         }
//         return count;
//     }
// }


class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int start = 0; 
        int end = nums.length-1;
        
        long count = 0;

        for(int i = start; i<=end ; i++) {
            int x = lower - nums[i]; // x se bade ya barabar pairs bana skte hain
            int y = upper - nums[i]; // y se chote ya barabr pairs bana skte hain
            
            count += findCountOfNumbers(nums,i+1, end, x, y);
        }
        return count;
    }

    public long findCountOfNumbers(int[] nums , int start , int end, int lower, int upper) {
        if(start > end) return 0;

        long lb = lowerBound(nums, start, end, lower);
        long ub = upperBound(nums, start, end, upper);

        if(lb == -1 || ub == -1 || lb > ub) return 0;
        return ub - lb + 1;
    }

    public int lowerBound(int[] nums, int start , int end , int target) {
        // barabar ya bada
        int ans = -1;
        while (start <= end) {
            int mid = start + ((end - start)>>1);
    
            if(nums[mid] >= target) {
                ans = mid;
                end = mid -1;
            }else if(nums[mid] < target ) {
                start = mid +1;
            }
        }
        return ans;
    }
    
    public int upperBound(int[] nums, int start , int end , int target) {
        
        int ans = -1;
        while (start <= end) {
            int mid = start + ((end - start)>>1);
    
            if(nums[mid] > target) {
                end = mid -1;
            }else if(nums[mid] <= target ) {
                ans = mid;
                start = mid +1;
            }
        }

        return ans;
    }
}