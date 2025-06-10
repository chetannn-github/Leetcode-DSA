class Solution {
    public int[] applyOperations(int[] nums) {
        int zeroPointer=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0 && i==nums.length-1){ 
                nums[zeroPointer] = nums[nums.length-1];
                if(i!=zeroPointer){
                    nums[i] = 0;
                }
                zeroPointer++;
                 
            }
            else if(i<=nums.length-2 && nums[i]!=0 && nums[i] == nums[i+1]){
                nums[zeroPointer] = 2* nums[i];
                nums[i+1] =0;
                if(i!=zeroPointer){
                    nums[i] = 0;
                }
                i++;
                zeroPointer++;
            }
            else if(nums[i]!=0 && nums[i]!=nums[i+1]){
                    nums[zeroPointer] = nums[i];
                    if(i!=zeroPointer){
                        nums[i] = 0;
                    }
                   zeroPointer++;
                }
            }

        return nums;
    }
}