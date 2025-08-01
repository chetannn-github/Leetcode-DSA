class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long totalSum = 0;
        for(int i=0; i<n; i++) {
            nums1[i] -= nums2[i];
            totalSum += (long) nums1[i];

            if(k == 0 && nums1[i] != 0) return -1; 
            if(k!= 0 && nums1[i] % k != 0) return -1;
        }

        if(totalSum != 0) return -1;
        if(k == 0) return 0;

        long ops = 0L;
        for(int i=0; i<n; i++) {
            ops += (long) Math.abs(nums1[i] / k);
        }

        return ops/2;
    }
}