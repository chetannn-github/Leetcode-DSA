class Solution {
    List<List<Integer>> solutions = new ArrayList<>();
    HashMap<Integer,Integer> hm = new HashMap<>();
    HashSet<Integer> hs = new HashSet<>();

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
            
            if((i!=0 &&  num == nums[i-1]) || hm.getOrDefault(num,0)==0){continue;}

            hm.put(num, hm.get(num)-1);
            temp.add(num);

            solve(nums, temp);

            hm.put(num, hm.get(num)+1);
            temp.remove(temp.size()-1);
            
        }

       
    }

    // public void solve(int[] nums, List<Integer> temp){
    //     if(temp.size() == nums.length){
    //         solutions.add(new ArrayList<>(temp));
    //         return;
    //     }


    //     for(int i=0; i<nums.length; i++){
    //         int num = nums[i];

    //         if(temp.size()==0 && i!=0 && nums[i]== nums[i-1]){ 
    //             continue;
    //         }else if(!hs.contains(i)){
    //             hs.add(i);
    //             temp.add(num);

    //             solve(nums, temp);

    //             hs.remove(i);
    //             temp.remove(temp.size()-1);

    //         }
    //     }

    // }
}