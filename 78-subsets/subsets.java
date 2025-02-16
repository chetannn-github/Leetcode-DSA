class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        solve(nums, temp,0);
        return result;
    }

    public void solve(int[] nums ,List<Integer> temp,int start){
        if(start==nums.length){ 
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[start]);
        solve(nums,temp,start+1);
        temp.remove(temp.size()-1);
        solve(nums,temp,start+1);
       
    }
}