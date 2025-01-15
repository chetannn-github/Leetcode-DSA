class Solution {
    public int minOperations(int[] nums, int x) {
        // cyclic array banakrr esii min length ki subarray jiska sum x ho simple
        // second idea can be kii aap total sum me se x hata de aur utne sum ka max subarray find krr le aur
        // baad uss length ho total se hata de
        int start = 0;
        int minLength = -1;
        int n = nums.length;
        int sum = 0;

        for(int end=0; end<2*n; end++){
            sum += nums[end%n];

            while(sum>x){
                sum -= nums[start%n];
                start++;
                
            }
            if(sum ==x && (end-start+1 <=n ) && ( (start ==0 && end<n ) || (start<=n-1 && end>=n-1) )){
                if(minLength!=-1){
                    minLength = Math.min(end-start+1, minLength);
                }else{
                    minLength = end -start+1;
                }
                
            }
            

            if(start>n){
                break;
            }
        }

        return minLength;
    }
}