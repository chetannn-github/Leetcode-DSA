class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);
        for(int i=0; i<n-2; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<n-1; j++) {
                if(i != j-1 && nums[j] == nums[j-1]) continue;
                int requiredVal = -(nums[i] + nums[j]);
                if(bs(nums,j+1,requiredVal)) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(requiredVal);
                    triplets.add(triplet);
                }
            }
        }

        return triplets;
    }


    private boolean bs(int[] nums, int startIdx, int required) {
        int endIdx = nums.length-1;

        while(startIdx <= endIdx) {
            int mid = startIdx + ((endIdx - startIdx) >> 1);

            if(nums[mid] == required) return true;
            else if(nums[mid] > required) {
                endIdx = mid - 1;
            }else startIdx = mid+1;
        }

        return false;
    }
}