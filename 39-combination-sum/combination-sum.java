class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> temp = new ArrayList<>();
        solve(nums,target, temp,0);
        return result;
    }

    public void solve(int[] nums, int target, List<Integer> temp, int start){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;

        }else if(target<0){
            return;
        }

        for(int i=start; i<nums.length; i++){
            int num = nums[i];

            temp.add(num);
            solve(nums,target-num,temp,i);

            temp.remove(temp.size()-1);
        }
        return;
    }
}