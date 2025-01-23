class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int curr = 0;
        

        for(int i=0; i<n; i++){
            if(nums[i]==0){
                // swap with curr index
                nums[i] = nums[curr] ^ nums[i];
                nums[curr] = nums[curr] ^ nums[i];
                nums[i] = nums[curr] ^ nums[i];

                curr++;
            }
        }
        
        for(int i=curr; i<n; i++){
            if(i==curr && nums[i]==1){
                curr++;
            }else if(i!= curr && nums[i]==1){
                // swap with curr index
                nums[i] = nums[curr] ^ nums[i];
                nums[curr] = nums[curr] ^ nums[i];
                nums[i] = nums[curr] ^ nums[i];

                curr++;
            }
                
            
        }
    }
}