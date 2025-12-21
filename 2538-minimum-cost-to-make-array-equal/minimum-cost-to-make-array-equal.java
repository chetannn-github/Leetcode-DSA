class Solution {
    public long minCost(int[] nums, int[] frequencies) {
        // simplyy median nikalna hogaa jese hum bachpan me nikalte the 
        int n = nums.length;
        long totalFreq = calculateTotalSum(frequencies);
        long medianPos = (totalFreq & 1) == 0 ? (totalFreq >> 1) : ((totalFreq + 1 ) >> 1);
        int grid[][] = new int[n][2];

        for(int i=0; i<n; i++) {
            grid[i][0] = nums[i];
            grid[i][1] = frequencies[i];
        }

        Arrays.sort(grid, (a,b)-> (a[0] - b[0]));
        int median = -1;
        long cf = 0;

        for(int i=0; i<n; i++) {
            cf += grid[i][1];
            if(cf >= medianPos) {
                median = grid[i][0];
                break;
            }
        }

        long result = 0;
        for(int i=0; i<n ; i++ ) {
            result += (long) Math.abs(nums[i] - median) * frequencies[i];
        }

        return result;
    }

    private long calculateTotalSum(int[] nums) {
        long totalSum = 0L;
        for(int num : nums) {
            totalSum += num;
        }
        return totalSum;
    }
}