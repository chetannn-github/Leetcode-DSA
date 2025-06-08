class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> list = new ArrayList();
        int n = nums.length;
        int dcr[] = new int[n];
        int inc[] = new int[n];
        dcr[0] = 1;
        inc[n-1] = 1;

        int count = 1;
        for(int i = 0; i<n-1; i++){
            if(nums[i] >= nums[i+1]){
                dcr[i+1] = ++count;
            }else{
                count = 1;
                dcr[i+1] = count;
            }
        }
        count = 1;
        for(int i=n-2; i>= 0;i--){
            if(nums[i] <= nums[i+1]){
                inc[i] = ++count;
            }else{
                count= 1;
                inc[i] = count;
            }
        }
        
        for(int i = k; i<n-k; i++){
            if(inc[i+1] >= k && dcr[i-1] >= k){
                list.add(i);
            }
        }
        return list;
    }  
}