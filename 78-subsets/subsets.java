class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        
        solve(nums, temp,0);
        return result;
    }

    public void solve(int[] nums ,List<Integer> temp,int start){
        result.add(new ArrayList<>(temp));

        if(temp.size()==nums.length){
            return;
        }

        for(int i=start; i<nums.length; i++){

            temp.add(nums[i]);
            solve(nums,temp,i+1);
            temp.remove(temp.size()-1);
        }
       
    }
}