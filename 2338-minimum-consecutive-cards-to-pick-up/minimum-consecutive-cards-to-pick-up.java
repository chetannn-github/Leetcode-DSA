// class Solution {
//     public int minimumCardPickup(int[] nums) {
//         // esi subrray batani hh jisme saare elements distinct + 1 dup ho aur length min ho
//         int start = 0;
//         int n = nums.length;
//         HashSet<Integer> hs = new HashSet<>();
//         int minLength = -1;

//         for(int end =0; end<n; end++){
           
//             while(hs.size()>0 && hs.contains(nums[end])){ 
//                 if(minLength!=-1){
//                     minLength = Math.min(minLength, end - start+1);
//                 }else{
//                     minLength = end -start+1;
//                 } 
//                 hs.remove(nums[start]);
//                 start++;
//             }
//             hs.add(nums[end]);
            
//         }

//         return  minLength ;
//     }
// }

// class Solution {
//     public int minimumCardPickup(int[] nums) {
//         // esi subrray batani hh jisme saare elements distinct + 1 dup ho aur length min ho
//         int start = 0;
//         int n = nums.length;
//         HashMap<Integer,Integer> hm = new HashMap<>();
//         int minLength = -1;

//         for(int end =0; end<n; end++){
        
//             hm.put(nums[end], hm.getOrDefault(nums[end],0)+1);

//             while(end-start+1 - hm.size() >=1){
//                 if(hm.get(nums[start])==1){
//                     hm.remove(nums[start]);
//                 }else{
//                     hm.put(nums[start], hm.getOrDefault(nums[start],0)-1);
//                 }
                
//                 if(end-start+1 - hm.size() == 1){
//                     if(minLength==-1){
//                         minLength = end -start +1;
//                     }else{
//                         minLength = Math.min(minLength, end-start+1);
//                     }
//                 }
//                 start++;
//             }
            
            
//         }

//         return  minLength ;
//     }
// }


class Solution {
    public int minimumCardPickup(int[] nums) {
        int start = 0;
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int minLength = Integer.MAX_VALUE;

        for(int end =0; end<n; end++){
            int curr = nums[end];
            hm.put(curr, hm.getOrDefault(curr,0)+1);

            while(hm.get(curr) > 1){
                hm.put(nums[start], hm.getOrDefault(nums[start],0)-1);
                minLength = Math.min(minLength, end-start+1);
                start++;
            }            
        }

        return  minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}