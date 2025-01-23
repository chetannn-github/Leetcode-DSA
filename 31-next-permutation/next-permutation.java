class Solution {
    public void nextPermutation(int[] nums) {
        int poi = -1;
        for(int i= nums.length-1; i>=1; i--){
            if(nums[i]>nums[i-1]){
                poi = i-1;
                break;
            }
        }

        if(poi==-1){
            reverse(nums);
            return;
        }
        int minIndex = poi+1;

        for(int i= nums.length-1; i>poi; i--){
            if(nums[i]>nums[poi]){
                minIndex = i;
                break;
            }
        }

        // swap min index and poi
        nums[minIndex] = nums[minIndex] ^ nums[poi];
        nums[poi] = nums[minIndex] ^ nums[poi];
        nums[minIndex] = nums[minIndex] ^ nums[poi];

        // now sort nums from poi+1 to n-1
        Arrays.sort(nums, poi+1, nums.length);

        return;


    }

    public void reverse(int[] nums){
        int start = 0;
        int end = nums.length-1;

        while(start<end){
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[start] ^ nums[end];
            nums[start] = nums[start] ^ nums[end];

            start++;
            end--;
        }
    }
}