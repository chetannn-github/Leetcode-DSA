class Solution {
    List<List<Integer>> solutions = new ArrayList<>();
    HashMap<Integer,Integer> hm = new HashMap<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num,0)+1);
        }
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, temp);

        return solutions;
    }

    public void solve(int[] nums, List<Integer> temp){
        if(temp.size() == nums.length){
            solutions.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            
            if((i==0 ||  num!= nums[i-1]) && hm.getOrDefault(num,0)>0){
                hm.put(num, hm.getOrDefault(num,0)-1);
                temp.add(num);

                solve(nums, temp);

                hm.put(num, hm.getOrDefault(num,0)+1);
                temp.remove(temp.size()-1);

            }
        }

       
    }
}