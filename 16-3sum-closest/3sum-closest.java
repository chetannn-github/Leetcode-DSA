class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // as index nhii maanaga hhh toh sort to avoid three for loops
        int n = nums.length;
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;

        for(int i=0; i<=n-3; i++){
            int start = i+1;
            int end = n-1;
            
            while(start<end){
                int sum =nums[start] + nums[end] + nums[i];

                if(Math.abs(sum-target)<Math.abs(closest-target)){
                    closest = sum;
                }
                

                if(sum > target){
                    end--;
                }else{
                    start++;
                }
            }

        }

        return closest;
    }
}