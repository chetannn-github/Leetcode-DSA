class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        long ops = 0;
        int prevTarget = 0;
        int n = target.length;
        
        for(int i=0; i<n; i++) {
            int currTarget = target[i] - nums[i];
            boolean isSignChanged = (prevTarget > 0 && currTarget < 0) || (prevTarget < 0 && currTarget > 0);
            
            if(isSignChanged) {
                ops += Math.abs(currTarget); 
            }
            else if(Math.abs(currTarget) > Math.abs(prevTarget)) {
                ops += Math.abs(currTarget) - Math.abs(prevTarget);  
            }
            prevTarget = currTarget;
        }

        return ops;
    }
}