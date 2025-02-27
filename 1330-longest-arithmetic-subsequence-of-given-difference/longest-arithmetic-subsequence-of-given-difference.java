class Solution {
    HashMap<Integer,List<Integer>> hm;
    int n;
    int dp[];
    public int longestSubsequence(int[] arr, int diff) {
        int maxLength = 0;
        n = arr.length;
        dp = new int[n];
        Arrays.fill(dp,-1);

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
        }

        for(int i=0;i<n; i++){
            maxLength  = Math.max(1 + solve(diff, i, arr),maxLength);
        }
        return maxLength;
    }


    public int solve(int diff,int last, int[] arr){
        if(last==n-1){
            return 0;
        }
        if(dp[last]!=-1){
            return dp[last];
        }
        int next = arr[last] + diff ; // AP ka next term 

        if(hm.containsKey(next)){
            // aage aur investigation kroo kii koi last se bade index prr hh kya 
            List<Integer> occ = hm.get(next);
            
            int max = 0;
            for(int i = 0; i<occ.size(); i++){
                int nextGoodIdx = occ.get(i);
                if( nextGoodIdx > last){
                    max = Math.max(max, 1 + solve(diff,nextGoodIdx,arr));
                }
            }
            return dp[last] = max;
        } 

        return dp[last] = 0;
    }
}
 