// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         HashSet<Integer> hs = new HashSet();
//         HashSet<List<Integer>> triplets = new HashSet();
       
//         for(int i=0; i<nums.length-2; i++){
//             if(!hs.contains(nums[i])){
//                 List<List<Integer>> pairs = twoSum(nums,0-nums[i],i+1);
//                 hs.add(nums[i]);
//                 for(int j=0; j<pairs.size(); j++){
//                     List<Integer> pair = pairs.get(j);
//                     pair.add(nums[i]);
//                     Collections.sort(pair);
                    
//                     if(!triplets.contains(pair)){
//                         ans.add(pair);
//                     } 
//                     triplets.add(pair);
//                 }   
//             }
//         }
//         return ans;
//     }

    
//     public List<List<Integer>> twoSum(int[] nums, int target ,int si) {
//         Set<Integer> hs = new HashSet<>();
//         Map<Integer,Integer> hm = new HashMap<>();
//         int n = nums.length;
//         List<List<Integer>> ans = new ArrayList<>();
//         for (int i = si; i < n; i++) {
//             int complement = target - nums[i];
//             if (hs.contains(complement) && !hm.containsKey(complement)) {
//                 List<Integer> pair = new ArrayList<>();
//                 pair.add(complement);
//                 pair.add(nums[i]);
//                 hm.put(complement, nums[i]);
//                 if(!ans.contains(pair)){
//                     ans.add(pair);
//                 } 
               
//             }
//             hs.add(nums[i]);
//         }

//         return ans; 
    
//     }

// }


class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;

        for(int i=0; i<=n-3; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            twoSum(nums, -nums[i], i+1);
            
        }

        return result;
    }

    
    public void twoSum(int[] nums, int target ,int si) {
       int ei = n-1;

       while(si<ei){
            
            if(nums[si] + nums[ei] == target){
                List<Integer> ans = new ArrayList<>();
                ans.add(-target);
                ans.add(nums[si]);
                ans.add(nums[ei]);
                
                result.add(ans);
                
                while(si+1 != ei && nums[si]== nums[si+1]){
                    si++;
                }
                while(si+1 != ei && nums[ei]== nums[ei-1]){
                    ei--;
                }
                si++;
                ei--;
            }
            else if( nums[si] + nums[ei] > target){
                ei--;
            }else if(nums[si] + nums[ei] < target){
                si++;
            }

            
            
       }
    
    }

}