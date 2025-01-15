class Solution {
    public int minimumCardPickup(int[] nums) {
        // esi subrray batani hh jisme saare elements distinct ho aur length min ho
        int start = 0;
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        int minLength = -1;

        for(int end =0; end<n; end++){
           
            while(hs.size()>0 && hs.contains(nums[end])){ 
                if(minLength!=-1){
                    minLength = Math.min(minLength, end - start+1);
                }else{
                    minLength = end -start+1;
                } 
                hs.remove(nums[start]);
                start++;
            }
            hs.add(nums[end]);
            
        }

        return  minLength ;
    }
}