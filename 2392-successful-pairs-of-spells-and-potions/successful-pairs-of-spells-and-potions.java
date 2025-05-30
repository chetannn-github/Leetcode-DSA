class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        long[] req = new long[potions.length];
        for(int i=0; i<potions.length; i++){
            if(success%potions[i]==0){
                req[i] = (success/potions[i]) ;
            }else{
                req[i] = (success/potions[i])+1;
            }
        }
        Arrays.sort(req);

        for(int i=0; i<spells.length; i++){
           spells[i] = findUpperBound(req,spells[i]);
        }

        return spells;
    }

    public int findUpperBound(long[] nums , int q){
        int start = 0; 
        int end = nums.length-1;
        int upper = nums.length;
        while(start<=end){
            int mid = start + ((end-start)>>1);
            if(nums[mid]>q){
                upper = mid;
                end = mid -1;
            }else{
                start = mid+1;
            }
        }

        return upper;
    }
}