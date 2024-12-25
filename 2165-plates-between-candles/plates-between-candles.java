class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int count = 0; 
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='|'){
                count++;
            }
        }

        if(count ==0){
            return new int[queries.length];
        }

        int[] candle = new int[count];
        int j =0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='|'){
                candle[j] = i;
                j++; 
            }
        }

        int[] pre = new int[candle.length];
        count = 0;
        j=1;
        for(int i=candle[0]+1; i<=candle[candle.length-1]; i++){
            if(s.charAt(i)=='*'){
                count++;
            }else{
                pre[j] = pre[j-1] + count;
                j++;
                count = 0;
            }
             
        }
        int ans[] = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            int first = findUpperBound(candle,queries[i][0]);
            int sec = findLowerBound(candle,queries[i][1]) -1;



            if(first>sec ){
                ans[i] = 0;
            }else{
                ans[i] = pre[sec] - pre[first];
            }

        }

       

        return ans;

       


    }

    public int findUpperBound(int[] nums , int q){
        int start = 0; 
        int end = nums.length-1;
        int upper = nums.length;
        while(start<=end){
            int mid = start + ((end-start)>>1);
            if(nums[mid]>=q){
                upper = mid;
                end = mid -1;
            }else{
                start = mid+1;
            }
        }

        return upper;
    }
    public int findLowerBound(int[] nums , int q){
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