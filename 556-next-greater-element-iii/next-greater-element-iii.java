class Solution {
    public int nextGreaterElement(int num) {
        int digits = (int) Math.log10(num) + 1;
        int nums[] = new int[digits];

        while(num!=0){
            nums[digits-1] = num%10;
            num /=10;
            digits--;
        }

        int poi = -1;
        int n = nums.length;

        for(int i= n-1; i>=1; i--){
            if(nums[i]>nums[i-1]){
                poi = i-1;
                break;
            }
        }

        if(poi==-1){
            return -1;
        }
        
        int minIndex = poi+1;

        for(int i= n-1; i>poi; i--){
            if(nums[i]>nums[poi]){
                minIndex = i;
                break;
            }
        }

        // swap min index and poi
        nums[minIndex] = nums[minIndex] ^ nums[poi];
        nums[poi] = nums[minIndex] ^ nums[poi];
        nums[minIndex] = nums[minIndex] ^ nums[poi];

        // now sort nums from poi+1 to n-1
        // Arrays.sort(nums, poi+1, n);

        // or reverse poi+1 to n-1
        reverse(nums,poi+1, n-1);
        long ans = 0;
        for(int i=0; i<n; i++){
            ans = ans*10 + nums[i];
        }
        // System.out.print(ans);
        return ans>Integer.MAX_VALUE ? -1 : (int)ans;
    }


    public void reverse(int[] nums, int start, int end){
        
        while(start<end){
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[start] ^ nums[end];
            nums[start] = nums[start] ^ nums[end];

            start++;
            end--;
        }
    }
}