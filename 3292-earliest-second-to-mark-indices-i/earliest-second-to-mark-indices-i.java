class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        // answer lies between numsSum+length to changeIndices.length
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        } 
        int start = sum + nums.length;
        int end = changeIndices.length;
        
        int ans = -1;

        while(start <= end){
            int mid = start + ((end - start)>>1);
            
            if(checkPossible(nums,changeIndices,mid)){
                end = mid -1;
                ans = mid;
            }else{
                start = mid +1;
            }
        }
        return ans;
    }

    public boolean checkPossible(int[] nums, int[] changeIndices, int sec){
        int[] last = new int[nums.length];

        for(int i=0; i<sec; i++){
            last[changeIndices[i] -1] = i;
        }

        int dec = 0;
        int mark = 0;

        for(int i=0; i<sec ; i++){
            int idx = changeIndices[i] - 1;

            if(i == last[idx]){

                if(dec>=nums[idx]){
                    dec -=nums[idx];
                    mark++;
                }else{
                    return false;
                }
            }else{
                dec++;
            }
        }
        return mark ==nums.length;

    }
}