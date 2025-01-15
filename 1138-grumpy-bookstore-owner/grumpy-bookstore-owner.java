class Solution {
    public int maxSatisfied(int[] customers, int[] nums, int k) {
        int n = nums.length;
        
        int start = 0;
        int max = 0;
        int cust = 0;

        List<Integer> oneIndices = new ArrayList<>();
        
        for( int i=0; i<n; i++){
            if(nums[i]==0){
                cust += customers[i];
            }
        }

        for(int end = 0; end<n; end++){
            if(nums[end] ==1){
                oneIndices.add(end);
            }

            while(nums[end] == 1 && oneIndices.size()>0 && end - oneIndices.get(0) +1 >k){
                // System.out.println(start);
                if(nums[start] ==1){
                    cust -= customers[start];
                    oneIndices.remove(0);
                }
                start++;
                
               
            }
            if(nums[end] ==1){
                cust += customers[end];     
            }
            
            // System.out.println(start+"...../////"+end+"--.."+cust);
            max = Math.max(cust,max);
        }

        return max;
    }
}