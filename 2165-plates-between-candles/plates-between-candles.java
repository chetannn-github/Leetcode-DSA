class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] pre = new int[n];
        boolean prevCandel = false;
        int count = 0;
        int candelCount = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch =='*' && prevCandel){
                count++; 
                
            }else if(ch == '|') {
                prevCandel = true;
                candelCount++;
            }
            pre[i] = count;
        }

        prevCandel = false;
        count = 0;
        int candles[] = new int[candelCount];
        int j = candelCount-1;

        for(int i=n-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch =='*' && prevCandel){
                count++;
                
            }else if( ch == '|') {
                prevCandel = true;
                candles[j--] = i;
            }
            // yhh meenee thoraa req koo analyse krne ke baad likhii hh
            if(ch == '*' && count == 0) {
                pre[i] = 0;
            }
            
        }

        int ans[] = new int[queries.length];


        for(int i=0; i<queries.length; i++){
            int first = findUpperBound(candles,queries[i][0]) ;
            int sec = findLowerBound(candles,queries[i][1]);
            
            if(first < sec) {
                ans[i] = pre[sec] - pre[first];
            }
            
        }

        return ans;
    }

    public int findUpperBound(int[] candles , int target){
        int start = 0, end = candles.length - 1;
        int ans = Integer.MAX_VALUE;

        while(start<=end){
            int mid = start + ((end-start)>>1);
            int val = candles[mid];

            if(val >= target){
                ans = candles[mid];
                end = mid -1;
            }else{
                start = mid+1;
            }
        }

        return ans;
    }
    public int findLowerBound(int[] candles , int target){
        int start = 0, end = candles.length - 1;
        int ans = Integer.MIN_VALUE;

        while(start<=end){
            int mid = start + ((end-start)>>1);
            int val = candles[mid];

            if(val <= target){
                ans = candles[mid];
                start = mid+1;
            }else{
                end = mid -1;
            }
        }

        return ans;
        }
    
}