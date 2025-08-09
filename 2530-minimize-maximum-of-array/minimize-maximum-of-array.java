// wrong approachhhhh
// class Solution {
//     public int minimizeArrayValue(int[] nums) {
//         int minMax = Integer.MIN_VALUE;
//         int n = nums.length;
//         int sum = nums[0];
//         int si = 0;
//         for(int i=0; i<n-1; i++) {
//             if(nums[i] > nums[i+1]) {
//                 int prevLength = i - si + 1;
//                 int avg = (int) Math.ceil((double) sum / prevLength);
//                 minMax = Math.max(minMax, avg);

//                 sum = nums[i+1];
//                 si = i+1;
//             }else {
//                 sum += nums[i+1];
//             }
//         }
//         int prevLength = n-1 - si + 1;
//         int avg = (int) Math.ceil((double) sum / prevLength);
//         minMax = Math.max(minMax, avg);
        

//         return minMax;
//     }
// }


class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        int start = nums[0], end = Integer.MIN_VALUE;
        
        for(int num : nums) {
            end = Math.max(end, num);
        }

        int result = end;

        while(start <= end) {
            int mid = start + ((end - start) >> 1);

            if(checkPossible(mid, nums)) {
                result = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return result;
    }


    public boolean checkPossible(int max, int[] nums) {
        int n = nums.length;
        long maxDecreasePossible = max - nums[0];

        for(int i=1; i<n; i++) {
            if(nums[i] > max) {
                if(nums[i] - max <= maxDecreasePossible) {
                    maxDecreasePossible -= nums[i] - max;
                } else return false;
            }else maxDecreasePossible += max - nums[i];
        }

        return true;
    }
}
