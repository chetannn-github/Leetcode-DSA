class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // as sirf numbers pucha hain aur uniqute puch so sort
        Arrays.sort(nums);
        n = nums.length;

        for(int i=0; i<=n-4; i++){
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
            }
            threeSum(nums,target-nums[i],i+1);
        }


        return result;
    }

    public void threeSum(int[] nums, long target, int start){

        for(int i=start; i<=n-3; i++){
            if(i!= start && nums[i]==nums[i-1]){
                continue;
            }
            twoSum(nums,target-nums[i], i+1,start-1);
        }
    }

    public void twoSum(int[] nums, long target, int start, int first){
        int second = start-1;
        int end = n-1;

        while(start<end){
            if(nums[start] + nums[end] == target){
                List<Integer> ans = new ArrayList<>();
                ans.add(nums[first]);
                ans.add(nums[second]);
                ans.add(nums[start]);
                ans.add(nums[end]);
                result.add(ans);

                while(start+1 != end  && nums[start] == nums[start+1]){
                    start++;
                }
                while(start+1 != end  && nums[end] == nums[end-1]){
                    end--;
                }
                start++;
                end--;


            }else if(nums[start] + nums[end] > target){
                end--;
            }else{
                start++;
            }
        }
        
    }
    
}