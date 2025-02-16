// mene phele yhh smjhh liya thaa kii hume distinct subsets chaiyee isliye commented wala code uske liyee hhh

// second approach is that why i am storing subsets in array me hashmap me krugaa milegaa bhii jaldi aur jayada dikkt bhii nhii hhh

// class Solution {
//     int result = 0;
//     int n;
//     public int beautifulSubsets(int[] nums, int k) {
//         n = nums.length;
//         // Arrays.sort(nums);
//         List<Integer> temp = new ArrayList<>();
//         solve(nums,k,temp,0);
//         return result-1; // kuki empty wala bhii add hogyaa hh

//     }

//     public void solve(int[] nums, int k, List<Integer> temp, int start){
//         int size = temp.size();
//         result++;
//         if(start == n){
//             return;
//         }
        

//         for(int i = start; i<n; i++){
//             // if(i>start && nums[i] == nums[i-1]){
//             //     continue;
//             // }
//             if(temp.size() == 0 || checkDifference(temp,k , nums[i])){
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
        return result-1;
    }

    public void solve(int[] nums, int k, int start,HashMap<Integer,Integer> hm){
        result++;
        if(start == nums.length){
            return;
        }
        
        for(int i = start; i<n; i++){
            boolean isPresent = hm.getOrDefault(nums[i]+k, 0)>0 || hm.getOrDefault(nums[i]-k, 0)>0;
            if(isPresent){
                continue;
            }
               
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
            
            solve(nums,k,i+1,hm);
            hm.put(nums[i], hm.getOrDefault(nums[i],0)-1);  
        }
    }

    
}



