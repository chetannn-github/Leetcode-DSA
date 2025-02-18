class Solution {
     List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, temp,0);
        return result;
    }

    public void solve(int[] nums ,List<Integer> temp,int start){
        result.add(new ArrayList<>(temp));

        if(temp.size()==nums.length){
            return;
        }

        
        HashSet<Integer> hs = new HashSet<>();
        for(int i=start; i<nums.length; i++){

        
            // if(i>start && nums[i]== nums[i-1]){
            //     continue;
            // }


            if(hs.contains(nums[i])){
                continue;
            }
            hs.add(nums[i]);
            temp.add(nums[i]);
            
            solve(nums,temp,i+1);
            temp.remove(temp.size()-1);
        }
       
    }
}