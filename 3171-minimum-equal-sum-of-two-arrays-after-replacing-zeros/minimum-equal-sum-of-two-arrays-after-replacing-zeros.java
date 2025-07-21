class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0L;
        long sum2 = 0L;
        boolean hasZeroInNum1 = false;
        boolean hasZeroInNum2 = false;

        for(int num : nums1) {
            sum1 += num == 0 ? 1 : num;
            if(num == 0) hasZeroInNum1 = true;
        }
        for(int num : nums2) {
            sum2 += num == 0 ? 1 : num;

            if(num == 0) hasZeroInNum2 = true;
        }

    
        if(!hasZeroInNum1 && !hasZeroInNum2) {
            return sum1 == sum2 ? sum1 : -1;
        }else if(!hasZeroInNum1) {
            return sum1 >= sum2 ? sum1 : -1;
        }else if(!hasZeroInNum2) {
            return sum1 <= sum2 ? sum2 : -1;
        }

        return Math.max(sum1,sum2);
    }
}