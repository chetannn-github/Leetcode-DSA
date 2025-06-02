class Solution {
    int MOD = 1_000_000_007;
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeSet<Integer> hs = new TreeSet<>();
        int n = nums1.length;
        long totalDiff = 0;
        int maxDiff = 0;

        for(int i=0; i<n; i++) {
            int currDiff = Math.abs(nums1[i] - nums2[i]);
            
            if(maxDiff < currDiff) {
                maxDiff = currDiff;
            }

            totalDiff += currDiff;
            hs.add(nums1[i]);
        }
        if(maxDiff == 0) return (int) totalDiff;

        long mostOptimum = Long.MIN_VALUE;

        for(int i=0; i<n; i++) {
            int currDiff = Math.abs(nums1[i] - nums2[i]);
            Integer higher = hs.ceiling(nums2[i]);
            Integer lower = hs.floor(nums2[i]);

            int minOfBoth = currDiff;

            if(higher != null) {
                minOfBoth = Math.min(minOfBoth, Math.abs(nums2[i] - higher));
            }
            if(lower != null) {
                minOfBoth = Math.min(minOfBoth, Math.abs(nums2[i] - lower));
            }

            if(currDiff > minOfBoth && mostOptimum < currDiff - minOfBoth) {
                mostOptimum = currDiff - minOfBoth;
            }

        }
        totalDiff -= mostOptimum ;
        
        totalDiff %= MOD;
        return (int) totalDiff;

    
    }
}