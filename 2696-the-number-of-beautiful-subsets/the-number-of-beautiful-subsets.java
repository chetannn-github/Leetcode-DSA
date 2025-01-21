// class Solution {
//     int result = 0;
//     int n;
//     public int beautifulSubsets(int[] nums, int k) {
//         n = nums.length;
//         // Arrays.sort(nums);
//         List<Integer> temp = new ArrayList<>();
//         solve(nums,k,temp,0);
//         return result;

//     }

//     public void solve(int[] nums, int k, List<Integer> temp, int start){
//         int size = temp.size();
//         if(size>0){
//             result++;
//         }
        

//         for(int i = start; i<n; i++){
//             if(size ==0 || checkDifference(temp,k , nums[i])){
//                 temp.add(nums[i]);
//                 solve(nums,k,temp,i+1);
//                 temp.remove(temp.size()-1);
//             }
//         }
//     }

//     public boolean checkDifference(List<Integer> temp, int k, int check){
//         for(Integer num : temp ){
//             if(Math.abs(num - check)== k){
//                 return false;
//             }
//         }

//         return true;
//     }
// }


class Solution {
    int result = 0;
    int n;
    

    public int beautifulSubsets(int[] nums, int k) {
        n = nums.length;
        
       HashMap<Integer,Integer> hm = new HashMap<>();
        solve(nums,k,0,hm);
        return result;

    }

    public void solve(int[] nums, int k, int start,HashMap<Integer,Integer> hm){
       
        if(start == nums.length){
            return;
        }
        
        
        for(int i = start; i<n; i++){
            if(hm.getOrDefault(nums[i]+k, 0)>0 || hm.getOrDefault(nums[i]-k, 0)>0 ){continue;}
               
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
            result++;
            solve(nums,k,i+1,hm);
            hm.put(nums[i], hm.getOrDefault(nums[i],0)-1);
                
            
        }
    }

    
}



