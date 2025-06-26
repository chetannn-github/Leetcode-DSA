class Solution {
    public int maxFrequency(int[] nums, int k) {
    Arrays.sort(nums);

    int result = 1;
    int start = 0;
    long sum = 0;
    int n = nums.length;

    for(int end = 0; end < n; end++) {
        sum += nums[end];

        while((long) nums[end] * (end - start + 1)  - sum > k) {
            sum -= nums[start++];
        }

        result = Math.max(result,end-start+1);
    }


    return result;
    }
}