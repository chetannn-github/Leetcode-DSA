class Solution {
    List<List<Integer>> result = new ArrayList<>();
    

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> temp = new ArrayList<>();

        solve(nums,temp,0);
        // System.out.print(result);

        return result;
    }

    public void solve(int[] nums, List<Integer> temp, int start){
        int size = temp.size();
        
        if(size>=2){
            if(temp.get(size-1) < temp.get(size-2) ){
                return;
            }else{
                result.add(new ArrayList<>(temp));
            }
            
            
        }
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i=start; i<nums.length; i++){
            if(hs.contains(nums[i])){
                continue;
            }
                
            temp.add(nums[i]);
hs.add(nums[i]);
            solve(nums,temp,i+1);

            temp.remove(temp.size()-1);
            
            
        }

    }
}