class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] mappedNums = new int[n][2];
        for(int i=0; i<n; i++) {
            mappedNums[i][0] = getMappedNums(nums[i], mapping);
            mappedNums[i][1] = i;
        }

        Arrays.sort(mappedNums,(a,b)->(a[1]==b[1] ? a[1]-b[1] : a[0]-b[0]));
        int[] result = new int[n];

        for(int i=0; i<n; i++) {
            int idx = mappedNums[i][1];
            result[i] = nums[idx];
        }
        return result;
    }

    private int getMappedNums(int num, int[] mapping) {
        if(num == 0) return mapping[0];
        
        int digits = (int) Math.log10(num) + 1;
        int result = 0;
        for(int i=0; i<digits; i++) {
            int divisor = (int) Math.pow(10,digits-i-1);
            int currDigit = num / divisor;
            num = num % divisor;

            result += divisor * mapping[currDigit];
        }

        return result;


    }
}