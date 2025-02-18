// tle
// class Solution {
    
//     HashSet<List<Integer>> result = new HashSet<>();

//     public List<List<Integer>> combinationSum2(int[] nums, int target) {
        
//         Arrays.sort(nums);
//         List<Integer> temp = new ArrayList<>();
//         solve(nums,target,temp,0);
//         List<List<Integer>> ans = new ArrayList<>();

//         for(List<Integer> combination : result){
//             ans.add(combination);
//         }
//         return ans;
//     }

//     public void solve(int[] nums, int target, List<Integer> temp,int start){
//         if(target==0){
//             result.add(new ArrayList<>(temp));
//         }
//         else if(target<0 || start>=nums.length){
//             return;
//         }

        
//         for(int i=start; i<nums.length; i++){
//             int num = nums[i];

//             temp.add(nums[i]);
//             solve(nums,target-num,temp,i+1);

//             temp.remove(temp.size()-1);

//         }
            
            
        
//     }
// }


// same as subset 2

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        solve(nums,target,temp,0);
        
        return result;
    }

    public void solve(int[] nums, int target, List<Integer> temp,int start){
        if(target==0){
            result.add(new ArrayList<>(temp));
        }else if(target<0 ){
            return;
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i=start; i<nums.length; i++){
            // nice statement!!!!!!!
            // if(i>start && nums[i] == nums[i-1]){
            //     continue;
            // }

            int num = nums[i];
            if(hs.contains(num)){
                continue;
            }
            
            
            hs.add(num);
            temp.add(num);
            solve(nums,target-num,temp,i+1);

            temp.remove(temp.size()-1);

        }

        

        
            
            
        
    }
}