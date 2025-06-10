class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int[] dist = new int[nums.length];
        int prev = nums.length;
       
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]==key){
                prev = 0;
            }else{
               dist[i] = ++prev;
            }
           
        } 
        for(int i=0; i<nums.length; i++){
            if(nums[i]==key){
                prev = 0;
                dist[i] = 0;
            }else{ 
                dist[i] =Math.min(dist[i] ,++prev) ;
                
            } 
            if(dist[i]<=k){
                ans.add(i);
            }
        }

        return ans;

    }
}