class Solution {
    HashMap<Integer,List<Integer>> hm;
    int n;
    int dp[][];
    public int longestArithSeqLength(int[] arr) {
        
        int maxLength = 0;
        n = arr.length;
        dp = new int[n][n];

        hm = new HashMap<>();
        for(int i = 0; i<n; i++){
            if(!(hm.containsKey(arr[i])) ){
                List<Integer> occr = new ArrayList<>();
                occr.add(i);
                hm.put(arr[i],occr);
                
            }else{
                List<Integer> occr = hm.get(arr[i]);
                occr.add(i);
                hm.put(arr[i], occr);
            }
           
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<n; i++){
            for(int j = i+1; j<n; j++){
                maxLength  = Math.max(2 + solve(i, j, arr),maxLength);
            }
        }
        return maxLength;
    }


    public int solve(int first,int second, int[] arr){
        

        if(dp[first][second]!=-1){
            return dp[first][second];
        }
        int next = arr[second] + arr[second] - arr[first] ; // AP ka next term 

        if(hm.containsKey(next)){
            // aage aur investigation kroo kii koi second se bade index prr hh kya 
            
            List<Integer> occ = hm.get(next);
            
            int max = 0;
            for(int i = 0; i<occ.size(); i++){
                int nextGoodIdx = occ.get(i);
                if( nextGoodIdx > second){
                    max = Math.max(max, 1 + solve(second,nextGoodIdx,arr));
                }
            }
            return dp[first][second] = max;
        } 

        return dp[first][second] = 0;
    }
}